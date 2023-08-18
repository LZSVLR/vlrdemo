package com.vlr.vlrdemo.dto;

import com.vlr.vlrdemo.entity.Account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Set<Account> accounts;

}
