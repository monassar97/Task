package com.training.cartservice.adapter.repository.rds;

import com.training.cartservice.adapter.repository.CartAggregateRepository;
import com.training.cartservice.adapter.repository.WishListAggregateRepository;
import com.training.cartservice.adapter.repository.wishlistrds.WishListAggregateJpaRepository;
import com.training.cartservice.aggregate.WishListAggregate;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartAggregateRDSRepositoryConfiguration {

    @Bean
    public CartAggregateRepository createCartAggregateRepository(CartAggregateJpaRepository jpaRepository, ModelMapper modelMapper) {
        return new CartAggregateRDSRepository(jpaRepository, modelMapper);
    }


}
