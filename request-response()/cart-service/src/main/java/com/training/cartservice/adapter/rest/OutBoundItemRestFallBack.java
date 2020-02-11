package com.training.cartservice.adapter.rest;

import org.springframework.stereotype.Component;

@Component
public class OutBoundItemRestFallBack implements OutBoundItemRest{


    @Override
    public ItemDTO loadItemById(String itemNo) {

        return new ItemDTO(itemNo,400);
    }
}
