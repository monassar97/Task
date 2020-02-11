package com.training.iteminventory.adapter.repository;

import com.training.iteminventory.adapter.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemInventoryJPARepo extends JpaRepository<ItemEntity,String> {

}
