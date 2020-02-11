package com.training.cartservice.adapter.repository.wishlistrds.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEntity {

    @Id
    private String itemNo;

    private int price;

    private int qty;

}
