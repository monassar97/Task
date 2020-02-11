package com.training.cartservice.command;

import lombok.Data;

@Data
public class RemoveItemFromWishListCommand extends AbstractCartCommand {
    private String wishListId;

    private String itemNo;
}
