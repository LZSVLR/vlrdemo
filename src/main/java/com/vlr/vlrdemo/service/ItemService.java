package com.vlr.vlrdemo.service;

import com.vlr.vlrdemo.dto.AccountDto;
import com.vlr.vlrdemo.dto.ItemDto;
import com.vlr.vlrdemo.entity.Item;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import com.vlr.vlrdemo.mapper.ItemMapper;
import com.vlr.vlrdemo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;


    //создание клиента
    public ItemDto createItem(ItemDto createItemDto) {
        Item created = itemRepository.save(itemMapper.map(createItemDto));
        return itemMapper.map(created);
    }

    //вывод объектов базы данных в виде дто списком
    public List<ItemDto> findAllItems()
    {
        return itemRepository.findAll().stream().map(itemMapper::map).collect(Collectors.toList());
    }
    public ItemDto findItemById(Long id)
    {
        if(itemRepository.findById(id).isEmpty())
        {
            throw new DataNotFoundException("Account not found!");
        }

        var find = itemRepository.findItemById(id);
        return itemMapper.map(find);
    }
   // обновление клиента
    @Transactional
    public ItemDto updateItem(ItemDto updateItemDto)
    {
        //не проходит проверка
        if(itemRepository.findById(updateItemDto.getId()).isEmpty())
        {
            throw new DataNotFoundException("Invalid ID, item was not found.");
        }
        itemRepository.updateItemById(updateItemDto.getName(),
                updateItemDto.getPrice(),
                updateItemDto.getDescription(),
                updateItemDto.getId());
        return updateItemDto;
    }
    //удаление клиента
//    @Transactional
    public void delete(Long id){itemRepository.deleteById(id);}
}
