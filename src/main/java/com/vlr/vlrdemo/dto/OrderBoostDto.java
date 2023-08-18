package com.vlr.vlrdemo.dto;

import com.vlr.vlrdemo.entity.Account;
import com.vlr.vlrdemo.entity.OrderStatus;
import com.vlr.vlrdemo.entity.Rank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderBoostDto {

    private Long id;
    private OrderStatus orderStatus;
    private Rank rank;
    private Double price;
    private String description;
    private Account performer;
    private Account assignee;

}
