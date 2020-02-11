package com.training.iteminventory.adapter.repository;

import com.training.iteminventory.adapter.entity.ItemEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ItemInventoryRepoImpl implements ItemInventorImpl {
    private final ItemInventoryJPARepo repository;

    public ItemInventoryRepoImpl(ItemInventoryJPARepo repository) {
        this.repository = repository;
    }

    @Override
    public void saveItem(ItemEntity itemEntity) {
        repository.save(itemEntity);
    }

    @Override
    public Optional<ItemEntity> loadItem(String itemNo) {
        return repository.findById(itemNo);
    }
}