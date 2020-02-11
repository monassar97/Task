package com.training.cartservice.common.command;

public interface CommandBus {


    public <U> U execute(Object commandObject);


}
