package com.vlr.vlrdemo.mapper;

import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.dto.ItemDto;
import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class ItemMapper {
    public ItemDto map(Item item)
    {
        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .value(item.getValue())
                .description(item.getDescription())
                .build();
    }
    //Преобразует переданную стороннюю ДТОшку в item
    public Item map(ItemDto requestCreateItemDto) {
        return Item.builder()
                .name(requestCreateItemDto.getName())
                .price(requestCreateItemDto.getPrice())
                .value(requestCreateItemDto.getValue())
                .description(requestCreateItemDto.getDescription())
                .build();
    }

}
