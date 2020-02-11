package com.training.cartservice.service;

import com.training.cartservice.adapter.repository.wishlistrds.WishListRDSRepository;
import com.training.cartservice.aggregate.WishListAggregate;
import com.training.cartservice.command.AbstractCartCommand;
import com.training.cartservice.command.AddItemToWishListCommand;
import com.training.cartservice.command.RemoveItemFromWishListCommand;
import com.training.cartservice.common.command.CommandHandler;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WishListService {
    private final WishListAggregate wishListAggregate;
    private final WishListRDSRepository wishListRDSRepository;
    private final ModelMapper mapper;

    public WishListService(WishListAggregate wishListAggregate, WishListRDSRepository wishListRDSRepository, ModelMapper mapper) {
        this.wishListAggregate = wishListAggregate;
        this.wishListRDSRepository = wishListRDSRepository;
        this.mapper = mapper;
    }

    @CommandHandler
    public void addItemToWishList(AddItemToWishListCommand addItemToWishListCommand) {
        wishListAggregate.removeItem(addItemToWishListCommand.getItemNo());
        wishListRDSRepository.insert(mapToAggregate(addItemToWishListCommand));
    }

    private WishListAggregate mapToAggregate(AbstractCartCommand addItemToWishListCommand) {
        return mapper.map(addItemToWishListCommand, WishListAggregate.class);
    }

    public void removeItemFromWishList(RemoveItemFromWishListCommand removeItemfromWishListCommand) {
        wishListAggregate.removeItem(removeItemfromWishListCommand.getItemNo());
        wishListRDSRepository.insert(mapToAggregate(removeItemfromWishListCommand));
    }

}
