package com.vlr.vlrdemo.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaymentDataDto {
    private String cardNumber;
    private double summary;
}
