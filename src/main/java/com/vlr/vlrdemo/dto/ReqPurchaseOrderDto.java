package com.vlr.vlrdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqPurchaseOrderDto {
    private long accountId;
    private String creditCard;
    private List<RequestItemsDto> items;


}
