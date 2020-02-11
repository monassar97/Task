package com.training.cartservice.command;

import lombok.Data;

@Data
public class RemoveItemFromCartCommand extends  AbstractCartCommand {

    private String cartId;

    private String itemNo;
}
