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
    private long id;
    private String name;
    private double price;
    private int value;
    private String description;

}
