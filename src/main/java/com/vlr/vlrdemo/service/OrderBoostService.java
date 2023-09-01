package com.vlr.vlrdemo.service;

import com.vlr.vlrdemo.dto.OrderBoostDto;
import com.vlr.vlrdemo.exception.DataNotFoundException;
import com.vlr.vlrdemo.mapper.OrderBoostMapper;
import com.vlr.vlrdemo.repository.OrderBoostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderBoostService {
    private final OrderBoostRepository orderBoostRepository;
    private final OrderBoostMapper orderBoostMapper;

    public List<OrderBoostDto> findAllOrderBoosts()
    {
        return orderBoostRepository.findAll().stream().map(orderBoostMapper::map).collect(Collectors.toList());
    }

    public OrderBoostDto findOrderBoostById(Long id)
    {
        if(orderBoostRepository.findById(id).isEmpty())
        {
            throw new DataNotFoundException("Order not found!");
        }
        return orderBoostMapper.map(orderBoostRepository.findOrderBoostById(id));
    }

    public OrderBoostDto createOrderBoost(OrderBoostDto orderBoostDto) {
        var created = orderBoostRepository.save(orderBoostMapper.map(orderBoostDto));
        return orderBoostMapper.map(created);
    }

    public OrderBoostDto updateOrderBoost(OrderBoostDto orderBoostDto)
    {
        if (orderBoostRepository.findById(orderBoostDto.getId()).isEmpty())
        {
            throw new DataNotFoundException("OrderBoostController not found!");
        }
        var update = orderBoostRepository.updateOrderBoostById(
                orderBoostDto.getRank(),
                orderBoostDto.getPrice(),
                orderBoostDto.getDescription(),
                orderBoostDto.getId()
        );
        return orderBoostMapper.map(update);
    }

    @Transactional
    public void deleteOrderBoost(Long id) {
        if (orderBoostRepository.findById(id).isEmpty()) {
            throw new DataNotFoundException("OrderBoostController not found!");
        } else {

            orderBoostRepository.deleteOrderBoostById(id);

        }
    }
}
