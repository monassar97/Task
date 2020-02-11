package com.training.cartservice.service;

import com.training.cartservice.adapter.repository.CartAggregateRepository;
import com.training.cartservice.adapter.repository.wishlistrds.WishListRDSRepository;
import com.training.cartservice.adapter.rest.ItemDTO;
import com.training.cartservice.adapter.rest.OutBoundItemRest;
import com.training.cartservice.aggregate.CartAggregate;
import com.training.cartservice.aggregate.CartStatus;
import com.training.cartservice.aggregate.WishListAggregate;
import com.training.cartservice.command.*;
import com.training.cartservice.common.command.CommandHandler;
import com.training.cartservice.common.exceptions.CartNotFoundException;
import com.training.cartservice.common.util.BeanLoader;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.Collections.emptyList;

@Service
public class CartService {

    private final CartAggregateRepository cartAggregateRepository;
    private final WishListRDSRepository wishListRDSRepository;

    public CartService(CartAggregateRepository cartAggregateRepository, WishListRDSRepository wishListAggregate) {
        this.cartAggregateRepository = cartAggregateRepository;

        this.wishListRDSRepository = wishListAggregate;
    }

    @CommandHandler
    public String openNewCart(OpenCartCommand openCartCommand) {

        String cartId = UUID.randomUUID().toString();
        CartAggregate cartAggregate =
                new CartAggregate(emptyList()
                        , openCartCommand.getUserId()
                        , cartId
                        , CartStatus.SAVED);

        cartAggregateRepository
                .insert(cartAggregate);

        return cartId;
    }

    public void clearCart(ClearCartCommand clearCartCommand) {

        String cartId = clearCartCommand.getCartId();
        CartAggregate cartAggregate = cartAggregateRepository
                .findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cartAggregate.clearCart();

        cartAggregateRepository.insert(cartAggregate);

    }

    public void addItemToCart(AddItemToCartCommand addItemToCArtCommand) {

        String cartId = addItemToCArtCommand.getCartId();
        CartAggregate cartAggregate = cartAggregateRepository
                .findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));
        OutBoundItemRest outBoundItemRest = BeanLoader.loadBean(OutBoundItemRest.class);

        ItemDTO itemDTO = outBoundItemRest.loadItemById(addItemToCArtCommand.getItemNo());


        cartAggregate.addItem(addItemToCArtCommand.getItemNo(),
                addItemToCArtCommand.getQty(),
                itemDTO.getPrice());

        cartAggregateRepository.insert(cartAggregate);
    }

    public void removeItemFromCart(RemoveItemFromCartCommand removeItemFromCArtCommand) {
        String cartId = removeItemFromCArtCommand.getCartId();
        CartAggregate cartAggregate = cartAggregateRepository
                .findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));

        cartAggregate.removeItem(removeItemFromCArtCommand.getItemNo());

        cartAggregateRepository.insert(cartAggregate);
    }

    public void moveItemToWishList(MoveItemToWishListCommand moveItemToWishListCommand) {
        CartAggregate cartAggregate = cartAggregateRepository
                .findById(moveItemToWishListCommand.getCartId())
                .orElseThrow(() -> new CartNotFoundException(moveItemToWishListCommand.getCartId()));

        WishListAggregate wishListaggregate = wishListRDSRepository.findById(moveItemToWishListCommand.getWishListId())
                .orElseThrow(() -> new CartNotFoundException(moveItemToWishListCommand.getWishListId()));

        cartAggregate.removeItem(moveItemToWishListCommand.getItemNo());

        wishListaggregate.addItem(moveItemToWishListCommand.getItemNo());
    }

    public void moveItemFromWishListToCart(MoveItemFromWishListCommand moveItemFromWishListCommand) {
        CartAggregate cartAggregate = cartAggregateRepository
                .findById(moveItemFromWishListCommand.getCartId())
                .orElseThrow(() -> new CartNotFoundException(moveItemFromWishListCommand.getCartId()));

        WishListAggregate wishListaggregate = wishListRDSRepository.findById(moveItemFromWishListCommand.getWishListId())
                .orElseThrow(() -> new CartNotFoundException(moveItemFromWishListCommand.getWishListId()));

        cartAggregate.removeItem(moveItemFromWishListCommand.getItemNo());

        wishListaggregate.addItem(moveItemFromWishListCommand.getItemNo());

    }

}