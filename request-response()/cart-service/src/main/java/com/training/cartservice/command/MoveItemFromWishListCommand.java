package com.training.cartservice.command;

import lombok.Data;

@Data
public class MoveItemFromWishListCommand extends AbstractCartCommand {
    private String wishListId;
    private String cartId;
    private String itemNo;
}
