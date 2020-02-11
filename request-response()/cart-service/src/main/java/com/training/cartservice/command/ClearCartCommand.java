package com.training.cartservice.command;

import lombok.Data;

@Data
public class ClearCartCommand extends AbstractCartCommand{

    private String cartId;
}
