package com.demo.currencyexchange.modal;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Getter
@Setter
@Component
public class CurrencyExchange {
    private String disclaimer;
    private String license;
    private Long timestamp;
    private String base;
    private Map<String, Double> rates;


}
