package com.loyalty.demo.configuration;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.loyalty.demo.domain.ItemRepository;
import com.loyalty.demo.service.FindAllUseCase;
import com.loyalty.demo.service.FindOneUseCase;
import com.loyalty.demo.service.FindOneWithDescriptionUseCase;
import com.loyalty.demo.service.InsertUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class DemoConfiguration {

    @Bean
    public FindOneUseCase findOneUseCase(ItemRepository itemRepository) {
        return new FindOneUseCase(itemRepository);
    }

    @Bean
    public FindAllUseCase findAllUseCase(ItemRepository itemRepository) {
        return new FindAllUseCase(itemRepository);
    }

    @Bean
    public InsertUseCase insertUseCase(ItemRepository itemRepository) {
        return new InsertUseCase(itemRepository);
    }

    @Bean
    public FindOneWithDescriptionUseCase findOneWithDescriptionUseCase() {
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());
        Faker faker = new Faker();
        return new FindOneWithDescriptionUseCase(fakeValuesService, faker);
    }
}
