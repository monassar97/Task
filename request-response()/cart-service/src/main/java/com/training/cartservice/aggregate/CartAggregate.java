package com.training.cartservice.aggregate;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

public class CartAggregate {

    private List<LineItem> lineItems = emptyList();
    private String userId;
    private String cartId;
    private CartStatus cartStatus;

    public CartAggregate(List<LineItem> lineItems, String userId, String cartId, CartStatus cartStatus) {
        this.lineItems = lineItems == null ? emptyList() : unmodifiableList(lineItems);
        this.userId = userId;
        this.cartId = cartId;
        this.cartStatus = cartStatus;
    }

    public void addItem(String itemNo, int qty, int price) {

        LineItem lineItem1 =
                lineItems
                        .stream()
                        .filter(lItem ->
                                lItem.getItemNo()
                                        .equalsIgnoreCase(itemNo))
                        .findFirst()
                        .map(lineItem -> lineItem
                                .toBuilder()
                                .qty(lineItem.getQty() + qty)
                                .build())
                        .orElse(new LineItem(itemNo, price, qty));

        List<LineItem> itemList = lineItems
                .stream()
                .filter(lItem -> !lItem.getItemNo().equalsIgnoreCase(itemNo))
                .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        itemList.add(lineItem1);

        this.lineItems = unmodifiableList(itemList);

    }

    public void removeItem(String itemNo) {
        List<LineItem> newList = lineItems.stream()
                .filter(lItem -> !lItem.getItemNo().equals(itemNo))
                .collect(Collectors.toList());
        this.lineItems = unmodifiableList(newList);
    }

    public int getTotalPrice() {
        return lineItems.stream()
                .mapToInt(item -> item.getPrice() * item.getQty())
                .sum();
    }

    public CartStatus getCartStatus() {
        return this.cartStatus;
    }


    public void clearCart(){
        this.lineItems = Collections.emptyList();
        this.cartStatus = CartStatus.CLEARED;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getUserId() {
        return userId;
    }

    public String getCartId() {
        return cartId;
    }
}
