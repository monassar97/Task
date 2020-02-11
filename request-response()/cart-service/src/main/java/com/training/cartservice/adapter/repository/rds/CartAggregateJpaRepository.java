package com.training.cartservice.adapter.repository.rds;

import com.training.cartservice.adapter.repository.rds.entity.CartAggregateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartAggregateJpaRepository extends JpaRepository<CartAggregateEntity, String> {
}
