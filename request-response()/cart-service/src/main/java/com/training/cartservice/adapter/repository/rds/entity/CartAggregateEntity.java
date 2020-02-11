package com.training.cartservice.adapter.repository.rds.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
public class CartAggregateEntity {

    @Id
    private String cartId;

    private String userId;

    private String cartStatus;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //@JoinColumn(name = "cart_id")
    private List<ItemEntity> items;
}
