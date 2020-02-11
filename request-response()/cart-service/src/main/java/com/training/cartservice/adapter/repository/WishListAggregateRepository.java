package com.training.cartservice.adapter.repository;

import com.training.cartservice.aggregate.CartAggregate;
import com.training.cartservice.aggregate.WishListAggregate;

import java.util.Optional;

public interface WishListAggregateRepository {
    void insert(WishListAggregate wishListAggregate);

    Optional<WishListAggregate> findById(String wishListId);
}
