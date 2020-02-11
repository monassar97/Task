package com.training.iteminventory.adapter.rest;

import com.training.iteminventory.adapter.dto.ItemDTO;
import com.training.iteminventory.model.Item;
import com.training.iteminventory.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemInventoryController {
    private final ModelMapper mapper;
    private final ItemService itemService;

    public ItemInventoryController(ModelMapper mapper, ItemService itemService) {
        this.mapper = mapper;
        this.itemService = itemService;
    }

    @GetMapping("{itemNo}")
    public Optional<ItemDTO> getItemById(@PathVariable("itemNo") String itemNo) {
        return itemService.getItem(itemNo).map(this::toItemDTO);
    }

    @PostMapping
    public void addItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(toItem(itemDTO));
    }

    public Item toItem(ItemDTO itemDTO) {
        return mapper.map(itemDTO, Item.class);
    }

    public ItemDTO toItemDTO(Item item) {
        return mapper.map(item, ItemDTO.class);
    }
}