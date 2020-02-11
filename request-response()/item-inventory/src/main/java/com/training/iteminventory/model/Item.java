package com.training.iteminventory.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Item {
    private String itemNo;
    private String description;
    private int price;
    private String name;
    private int qty;
}
