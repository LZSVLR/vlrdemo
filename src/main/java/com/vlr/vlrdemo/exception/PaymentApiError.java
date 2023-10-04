package com.vlr.vlrdemo.exception;

import com.vlr.vlrdemo.entity.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentApiError {
    private String message;
    private PaymentStatus paymentStatus;
    private LocalDateTime timeStamp;
}
