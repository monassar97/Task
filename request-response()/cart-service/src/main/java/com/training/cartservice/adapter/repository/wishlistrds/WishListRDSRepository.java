package com.training.cartservice.adapter.repository.wishlistrds;

import com.training.cartservice.adapter.repository.WishListAggregateRepository;
import com.training.cartservice.adapter.repository.wishlistrds.entity.WishListEntity;
import com.training.cartservice.aggregate.WishListAggregate;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Optional;

@Component
public class WishListRDSRepository implements WishListAggregateRepository {
    private final WishListAggregateJpaRepository repository;
    private final ModelMapper mapper;

    public WishListRDSRepository(WishListAggregateJpaRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void insert(WishListAggregate wishListAggregate) {
        repository.save(wishListAggregate);
    }

    private WishListEntity mapToEntity(WishListAggregate wishListAggregate) {
        return mapper.map(wishListAggregate, WishListEntity.class);
    }

    @Override
    public Optional<WishListAggregate> findById(String wishListId) {
        return repository.findById(wishListId);
    }

    private <U> U toWishList(WishListEntity wishListEntity) {
        return mapper.map(wishListEntity, (Type) WishListAggregate.class);
    }
}
