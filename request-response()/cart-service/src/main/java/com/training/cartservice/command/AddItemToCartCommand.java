package com.training.cartservice.command;

import lombok.Data;

@Data
public class AddItemToCartCommand extends AbstractCartCommand{

    private String cartId;

    private String itemNo;

    private int qty;

}
