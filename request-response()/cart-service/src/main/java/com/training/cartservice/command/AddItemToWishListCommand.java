package com.training.cartservice.command;

import lombok.Data;

@Data
public class AddItemToWishListCommand extends AbstractCartCommand{
    private String WishListId;
    private String itemNo;
    private String userId;

}
