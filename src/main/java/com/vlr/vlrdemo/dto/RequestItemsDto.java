package com.vlr.vlrdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// PurchaseItems содержит Long itemId Long count

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//использовать примитивы
public class RequestItemsDto {
    private long itemId;
    private long count;
}
