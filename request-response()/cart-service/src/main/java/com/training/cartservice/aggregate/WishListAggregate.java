package com.training.cartservice.aggregate;

import com.training.cartservice.adapter.rest.OutBoundItemRest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WishListAggregate {
    private List<WishListItem> items;
    private String wishListId;
    private String userId;

    public WishListAggregate() {
    }

    public WishListAggregate(List<WishListItem> items, String wishListId, String userId) {
        this.items = items;
        this.wishListId = wishListId;
        this.userId = userId;
    }

    public List<WishListItem> getItems() {
        return items;
    }

    public String getWishListId() {
        return wishListId;
    }

    public String getUserId() {
        return userId;
    }

    //test
    public void removeItem(String itemNo) {
        items.remove(itemNo);
    }

    //test
    public void addItem(String itemNo) {

        items.add(new WishListItem(itemNo, 0));
    }
}
