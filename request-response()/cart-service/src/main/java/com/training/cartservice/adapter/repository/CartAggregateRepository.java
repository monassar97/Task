package com.training.cartservice.adapter.repository;



import com.training.cartservice.aggregate.CartAggregate;

import java.util.Optional;

public interface CartAggregateRepository {

    void insert(CartAggregate cartAggregate);

    Optional<CartAggregate> findById(String cartId);

}
