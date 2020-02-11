package com.training.iteminventory.adapter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ItemEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private String itemNo;
    private String description;
    private int price;
    private String name;
    private int qty;
}