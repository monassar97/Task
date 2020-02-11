package com.training.cartservice.adapter.rest;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "item-service"

        ,fallback = OutBoundItemRestFallBack.class)
public interface OutBoundItemRest {


    @GetMapping("/items/{itemNo}")
    public ItemDTO loadItemById(@PathVariable("itemNo") String itemNo);
}
