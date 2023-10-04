package com.vlr.vlrdemo.config;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
@Data
@RequiredArgsConstructor
public class AppProperty {
    private String paymentUrl;
}
