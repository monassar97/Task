package com.training.cartservice.adapter.repository.rds;

import com.training.cartservice.adapter.repository.CartAggregateRepository;
import com.training.cartservice.adapter.repository.rds.entity.CartAggregateEntity;
import com.training.cartservice.adapter.repository.rds.entity.ItemEntity;
import com.training.cartservice.aggregate.CartAggregate;
import com.training.cartservice.aggregate.CartStatus;
import com.training.cartservice.aggregate.LineItem;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class CartAggregateRDSRepository implements CartAggregateRepository {

    private final CartAggregateJpaRepository jpaRepository;

    private final ModelMapper mapper;

    public CartAggregateRDSRepository(CartAggregateJpaRepository jpaRepository, ModelMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public void insert(CartAggregate cartAggregate) {
        jpaRepository.save(mapToEntity(cartAggregate));
    }

    @Override
    public Optional<CartAggregate> findById(String cartId) {
        return jpaRepository.findById(cartId)
                .map(this::mapToAggregate);
    }

    private CartAggregate mapToAggregate(CartAggregateEntity entity) {
        Type listType = new TypeToken<List<LineItem>>() {
        }.getType();
        List<LineItem> lineItems = mapper.map(entity.getItems(), listType);
        return new CartAggregate(lineItems, entity.getCartId(), entity.getUserId(), CartStatus.valueOf(entity.getCartStatus()));
    }

    private CartAggregateEntity mapToEntity(CartAggregate cartAggregate) {
        Type listType = new TypeToken<List<ItemEntity>>() {
        }.getType();
        List<ItemEntity> items = mapper.map(cartAggregate.getLineItems(), listType);
        return CartAggregateEntity
                .builder()
                .cartId(cartAggregate.getCartId())
                .userId(cartAggregate.getUserId())
                .cartStatus(cartAggregate.getCartStatus().name())
                .items(items)
                .build();
    }
}
