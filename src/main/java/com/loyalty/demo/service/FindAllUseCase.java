package com.loyalty.demo.service;

import com.loyalty.demo.domain.ItemRepository;
import com.loyalty.demo.infrastructure.ItemDTO;
import org.springframework.data.domain.Sort;

import java.util.stream.Stream;

public class FindAllUseCase {

    private ItemRepository itemRepository;

    public FindAllUseCase(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Stream<ItemDTO> findAll (String direction) {
       return itemRepository.findAll(Sort.by(Sort.Direction.fromString(direction), "cost")).stream()
               .map(x -> ItemDTO.builder()
                       .id(x.getId())
                       .name(x.getName())
                       .cost(x.getCost())
                       .build());
    }
}
