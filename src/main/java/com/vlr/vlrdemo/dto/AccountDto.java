package com.vlr.vlrdemo.dto;



import lombok.*;

import java.util.List;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Double balance;
    private List<Long> performOrderBoosts;
    private List<Long> assigneeOrderBoosts;
    private Set<ItemDto> items; // должно быть dto?

}
