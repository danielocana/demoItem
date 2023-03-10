package com.loyalty.demo.service;

import com.loyalty.demo.domain.Item;
import com.loyalty.demo.domain.ItemRepository;
import com.loyalty.demo.infrastructure.ItemDTO;

public class InsertUseCase {
    private ItemRepository itemRepository;

    public InsertUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDTO insertItem(ItemDTO itemDTO) {
       Item save = itemRepository.save(new Item(itemDTO.getId(), itemDTO.getName(), itemDTO.getCost()));
       return ItemDTO.builder()
               .id(save.getId())
               .name(save.getName())
               .cost(save.getCost())
               .build();
    }
}
