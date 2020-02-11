package com.training.cartservice.adapter.repository.wishlistrds;

import com.training.cartservice.adapter.repository.wishlistrds.entity.WishListEntity;
import com.training.cartservice.aggregate.WishListAggregate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListAggregateJpaRepository extends JpaRepository<WishListAggregate,String> {
}
