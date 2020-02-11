package com.training.cartservice.command;

import lombok.Data;

@Data
public class MoveItemToWishListCommand extends AbstractCartCommand{
    private String wishListId;
    private String cartId;
    private String itemNo;
}
