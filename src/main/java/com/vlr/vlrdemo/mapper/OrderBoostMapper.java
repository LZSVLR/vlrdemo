package com.vlr.vlrdemo.mapper;

import com.vlr.vlrdemo.dto.ItemDto;
import com.vlr.vlrdemo.dto.OrderBoostDto;
import com.vlr.vlrdemo.entity.Item;
import com.vlr.vlrdemo.entity.OrderBoost;
import org.springframework.stereotype.Component;

@Component
public class OrderBoostMapper {
    public OrderBoostDto map(OrderBoost orderBoost)
    {
        return OrderBoostDto.builder()
                .id(orderBoost.getId())
                .orderStatus(orderBoost.getOrderStatus())
                .rank(orderBoost.getRank())
                .price(orderBoost.getPrice())
                .description(orderBoost.getDescription())
                .performer(orderBoost.getPerformer())
                .assignee(orderBoost.getAssignee())
                .build();

    }

    public OrderBoost map(OrderBoostDto orderBoostDto) {
        return OrderBoost.builder()
                .rank(orderBoostDto.getRank())
                .price(orderBoostDto.getPrice())
                .description(orderBoostDto.getDescription())
//                .performer(orderBoostDto.getPerformer())
//                .assignee(orderBoostDto.getAssignee())
                .build();
    }
}
