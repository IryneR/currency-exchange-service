package com.demo.currencyexchange.controller;

import com.demo.currencyexchange.modal.CurrencyExchange;
import com.demo.currencyexchange.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyController {

        @Autowired
        private CurrencyService currencyService;

        @GetMapping("/currency-exchange")
        public ResponseEntity<CurrencyExchange> getCurrencyExchange() {
            CurrencyExchange currencyExchange = currencyService.getCurrencyExchange();
                return ResponseEntity.status(HttpStatus.OK).body(currencyExchange);
        }

}
