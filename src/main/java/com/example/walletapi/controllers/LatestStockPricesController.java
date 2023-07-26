package com.example.walletapi.controllers;

import com.example.walletapi.services.LatestStockPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class LatestStockPricesController {

    @Autowired
    private LatestStockPriceService latestStockPriceService;
    @GetMapping("/stocks/prices")
    public ResponseEntity<Object> prices() {
        return new ResponseEntity<>(latestStockPriceService.prices(), HttpStatus.OK);
    }
}
