package com.vlr.vlrdemo.service;

import com.vlr.vlrdemo.dto.ItemDto;
import com.vlr.vlrdemo.dto.RequestItemsDto;
import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.Item;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import com.vlr.vlrdemo.mapper.ItemMapper;
import com.vlr.vlrdemo.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemDto createItem(ItemDto createItemDto) {
        //нужна проверка дто
        Item created = itemRepository.save(itemMapper.map(createItemDto));
        return itemMapper.map(created);
    }

    public List<ItemDto> findAllItems()
    {
        return itemRepository.findAll().stream().map(itemMapper::map).collect(Collectors.toList());
    }
    public ItemDto findItemById(Long id)
    {
        var found = new Item();
        Optional<Item> findItem = Optional.ofNullable(itemRepository.findItemById(id));
        if(findItem.isPresent())
        {
            found = findItem.get();
        }
        else throw new  DataNotFoundException("item not found");
        return itemMapper.map(found);
    }

    @Transactional
    public ItemDto updateItem(ItemDto updateItemDto)
    {
        Optional<Item> findItem = Optional.ofNullable(itemRepository.findItemById(updateItemDto.getId()));
            if(findItem.isPresent())
            {
               itemRepository.updateItemById(updateItemDto.getName(),
                        updateItemDto.getPrice(),
                        updateItemDto.getDescription(),
                        updateItemDto.getId());
            }

        return updateItemDto;
    }
    public void delete(Long id){itemRepository.deleteById(id);}
    public List<ItemDto> checkAvailabilityItemsById(List<RequestItemsDto> orderList)
    {
        List<Long> ids = orderList.stream().map(RequestItemsDto::getItemId).toList();
        return itemRepository.findExistingIds(ids).stream().map(itemMapper::map).toList();
    }
    public List<Item> getItemsById(List<RequestItemsDto> orderList)
    {
        List<Long> ids = orderList.stream().map(RequestItemsDto::getItemId).toList();
        return itemRepository.findExistingIds(ids);
    }
}
