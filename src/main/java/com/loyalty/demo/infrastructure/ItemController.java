package com.loyalty.demo.infrastructure;

import com.loyalty.demo.service.FindAllUseCase;
import com.loyalty.demo.service.FindOneUseCase;
import com.loyalty.demo.service.FindOneWithDescriptionUseCase;
import com.loyalty.demo.service.InsertUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping(path = "/items", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {

    private FindOneUseCase findOneUseCase;
    private FindAllUseCase findAllUseCase;
    private InsertUseCase insertUseCase;

    private FindOneWithDescriptionUseCase findOneWithDescriptionUseCase;

    public ItemController(FindOneUseCase findOneUseCase, FindAllUseCase findAllUseCase, InsertUseCase insertUseCase,
                          FindOneWithDescriptionUseCase findOneWithDescriptionUseCase) {
        this.findOneUseCase = findOneUseCase;
        this.findAllUseCase = findAllUseCase;
        this.insertUseCase = insertUseCase;
        this.findOneWithDescriptionUseCase = findOneWithDescriptionUseCase;
    }

    @GetMapping("/{id}")
    public ItemDTO item (@PathVariable("id")Long id) {
        return findOneUseCase.getOne(id);
    }

    @GetMapping("/{id}/description")
    public ItemWithDescriptionDTO itemWithDescription (@PathVariable("id")Long id) {
        return findOneWithDescriptionUseCase.withDescriptionDTO(id);
    }

    @GetMapping
    public List<ItemDTO> items () {
        return findAllUseCase.findAll().collect(Collectors.toList());
    }

    @PostMapping
    public ItemDTO insert (@RequestBody ItemDTO itemDTO) {
        return insertUseCase.insertItem(itemDTO);
    }
}
