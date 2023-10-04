package com.vlr.vlrdemo.mapper;

import com.vlr.vlrdemo.dto.PurchaseOrderDto;
import com.vlr.vlrdemo.entity.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class PurchaseOrderMapper {
    private final ItemMapper itemMapper;
    private final AccountMapper accountMapper;

    public PurchaseOrder map(PurchaseOrderDto purchaseOrderDto)
    {
        return PurchaseOrder.builder()
                .orderPrice(purchaseOrderDto.getOrderPrice())
                .items(purchaseOrderDto.getItems().stream().map(itemMapper::map).collect(Collectors.toList()))
                .account(accountMapper.map(purchaseOrderDto.getAccount()))
                .build();
    }
    public PurchaseOrderDto map(PurchaseOrder purchaseOrder)
    {
        return PurchaseOrderDto.builder()
                .id(purchaseOrder.getId())
                .orderPrice(purchaseOrder.getOrderPrice())
                .purchaseStatus(purchaseOrder.getPurchaseStatus())
                .items(purchaseOrder.getItems().stream().map(itemMapper::map).collect(Collectors.toList()))
                .account(accountMapper.map(purchaseOrder.getAccount()))
                .build();
    }
}
