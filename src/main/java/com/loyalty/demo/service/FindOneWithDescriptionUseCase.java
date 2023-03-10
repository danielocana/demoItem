package com.loyalty.demo.service;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.loyalty.demo.infrastructure.ItemWithDescriptionDTO;

public class FindOneWithDescriptionUseCase {

    private FakeValuesService fakeValuesService;
    private Faker faker;

    public FindOneWithDescriptionUseCase(FakeValuesService fakeValuesService, Faker faker) {
        this.fakeValuesService = fakeValuesService;
        this.faker = faker;
    }

    public ItemWithDescriptionDTO withDescriptionDTO (Long id) {
        return ItemWithDescriptionDTO.builder()
                .id(id)
                .description(faker.ancient().primordial())
                .build();
    }
}
