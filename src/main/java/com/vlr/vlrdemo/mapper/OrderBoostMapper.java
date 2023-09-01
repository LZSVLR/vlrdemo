package com.vlr.vlrdemo.mapper;

import com.vlr.vlrdemo.dto.OrderBoostDto;

import com.vlr.vlrdemo.entity.OrderBoost;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@Component
@RequiredArgsConstructor
public class OrderBoostMapper {
      private final AccountMapper accountMapper;
    public OrderBoostDto map(OrderBoost orderBoost)
    {

        return OrderBoostDto.builder()
                .id(orderBoost.getId())
                .orderStatus(orderBoost.getOrderStatus())
                .rank(orderBoost.getRank())
                .price(orderBoost.getPrice())
                .description(orderBoost.getDescription())
                .performer(accountMapper.map(orderBoost.getPerformer()))
                .assignee(accountMapper.map(orderBoost.getAssignee()))
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
