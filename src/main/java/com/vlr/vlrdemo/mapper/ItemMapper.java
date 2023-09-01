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
                .description(item.getDescription())
                .accountsId(item.getAccounts().stream().map(Account::getId).collect(Collectors.toSet()))
                .build();
    }
    //Преобразует переданную стороннюю ДТОшку в item
    public Item map(ItemDto requestCreateItemDto) {
        return Item.builder()
                .name(requestCreateItemDto.getName())
                .price(requestCreateItemDto.getPrice())
                .description(requestCreateItemDto.getDescription())
//                .accounts(requestCreateItemDto.getAccounts())
                .build();
    }

}
