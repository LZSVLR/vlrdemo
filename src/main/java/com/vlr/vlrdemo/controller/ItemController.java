package com.vlr.vlrdemo.controller;

import com.vlr.vlrdemo.dto.ItemDto;
import com.vlr.vlrdemo.exception.CreateValidationException;
import com.vlr.vlrdemo.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/demo/items")
@RequiredArgsConstructor
@Slf4j
public class ItemController {
    private final ItemService itemService;

    @GetMapping()
    public ResponseEntity<List<ItemDto>> showItems()
    {
        return ResponseEntity.ok(itemService.findAllItems());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findItemById(@PathVariable Long id)
    {
        return ResponseEntity.ok(itemService.findItemById(id));
    }
    @PostMapping
    public ResponseEntity<ItemDto> create(@RequestBody
                                                    ItemDto createItemDto) {
        if(createItemDto.getName() == null)
        {
            throw new CreateValidationException("Name can't be null");
        }
        //Повторяющийся кусок кода с client
        return ResponseEntity.ok(itemService.createItem(createItemDto));
    }

    //Обновление
    @PutMapping
    public ResponseEntity<ItemDto> update(@RequestBody ItemDto updateItem)
    {
        return ResponseEntity.ok(itemService.updateItem(updateItem));

    }

    //Удаление
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id)
    {
        //Нужна проверка на существование объекта в бд?
        itemService.delete(id);
        return ResponseEntity.ok("Item successfully deleted!"+" ID: "+id);
    }
    //Создать контроллер который отвечает за покупку товара
    //Нужно чтобы контроллер принимал List<ID товаров>
    //Проверить что такие товары существуют
    //purchase_order модель, она содержит List<PurchaseItems>, PurchaseItems содержит Long itemId Long count
    //Сервис который проверяет что есть такие товары
    //Сервис который отвечает за отправку сообщений в payment
    //Карту пользов. и сумму всех товаров которые он хочет купить и отправить в paYMENT
    //
    //

}
