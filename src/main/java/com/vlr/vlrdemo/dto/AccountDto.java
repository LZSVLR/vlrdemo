package com.vlr.vlrdemo.dto;


import com.vlr.vlrdemo.entity.Item;
import com.vlr.vlrdemo.entity.OrderBoost;
import lombok.*;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Double balance;
    private List<OrderBoost> performOrderBoosts;
    private List<OrderBoost> assigneeOrderBoosts;
    private Set<Item> items;

}
