package com.training.cartservice.adapter.repository.rds.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemEntity {

    @Id
    private String itemNo;

    private int price;

    private int qty;

}
