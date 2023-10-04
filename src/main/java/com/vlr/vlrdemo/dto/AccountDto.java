package com.vlr.vlrdemo.dto;



import lombok.*;

import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto {
    private long id;
    private String name;
    private String phoneNumber;
    private String creditCard;


}
