package com.training.iteminventory.adapter.repository;

import com.training.iteminventory.adapter.entity.ItemEntity;

import java.util.Optional;

public interface ItemInventorImpl {
    public void saveItem(ItemEntity itemEntity);

    public Optional<ItemEntity> loadItem(String itemNo);
}
