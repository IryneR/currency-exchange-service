package com.demo.currencyexchange.service;

import com.demo.currencyexchange.modal.CurrencyExchange;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyService {

    public CurrencyExchange getCurrencyExchange() {

        RestTemplate restTemplate = new RestTemplate(new SimpleClientHttpRequestFactory());
        ResponseEntity<CurrencyExchange> response = null;
        try {
            response = restTemplate.getForEntity("https://openexchangerates.org/api/latest.json" +
                    "?app_id=c5da9a4af3cd478799938408316f9e59", CurrencyExchange.class);
        } catch (RestClientException e) {
            return null;
        }
        return response.getBody();
    }

}