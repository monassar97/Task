package com.training.cartservice.aggregate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WishListItem {
    private String itemNo;
    private int price;
}
