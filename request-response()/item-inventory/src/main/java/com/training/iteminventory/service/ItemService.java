package com.training.iteminventory.service;

import com.training.iteminventory.adapter.entity.ItemEntity;
import com.training.iteminventory.adapter.repository.ItemInventoryRepoImpl;
import com.training.iteminventory.model.Item;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    private final ItemInventoryRepoImpl repo;
    private final ModelMapper mapper;

    public ItemService(ItemInventoryRepoImpl repo, ModelMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Optional<Item> getItem(String itemNo) {
        return repo.loadItem(itemNo).map(this::maptoItem);
    }

    public void addItem(Item item) {
        repo.saveItem(mapToEntity(item));
    }

    private ItemEntity mapToEntity(Item item) {
        return mapper.map(item, ItemEntity.class);
    }

    private <U> U maptoItem(ItemEntity itemEntity) {
        return (U) mapper.map(itemEntity, Item.class);
    }

}