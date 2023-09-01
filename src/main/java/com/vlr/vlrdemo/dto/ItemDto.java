package com.vlr.vlrdemo.dto;

import com.vlr.vlrdemo.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ItemDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private Set<Long> accountsId;

}
