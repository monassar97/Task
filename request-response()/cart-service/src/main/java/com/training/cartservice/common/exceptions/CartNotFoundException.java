package com.training.cartservice.common.exceptions;

public class CartNotFoundException extends AbstractTrainingException {
    public CartNotFoundException(String id) {
        super(String.format("Cart with id `%s` Not Found!!!", id));
    }
}
