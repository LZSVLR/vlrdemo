package com.vlr.vlrdemo.dto;

import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.Item;
import com.vlr.vlrdemo.entity.PurchaseStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrderDto {
    private Long id;
    private Double orderPrice;
    private PurchaseStatus purchaseStatus;
    private AccountDto account;
    private List<ItemDto> items;
}
