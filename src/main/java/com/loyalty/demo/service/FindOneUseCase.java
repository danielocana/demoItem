package com.loyalty.demo.service;

import com.loyalty.demo.domain.Item;
import com.loyalty.demo.domain.ItemRepository;
import com.loyalty.demo.infrastructure.ItemDTO;

public class FindOneUseCase {

    private ItemRepository itemRepository;

    public FindOneUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemDTO getOne (Long id) {
        Item one = itemRepository.getOne(id);
        return ItemDTO.builder()
                .id(one.getId())
                .name(one.getName())
                .cost(one.getCost())
                .build();
    }
}
