package com.example.ESEG.controller;

import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class CurrencyController {

    public CurrencyController() {
    }



    @RequestMapping("/api/currency/eurToUSD/{money}")
    public Double eurToUsd(@PathVariable Double money) {
        final double exchangeRate = 1.1;
        money= money* exchangeRate;

        // Runden und das Ergebnis auf eine ganze Zahl casten
        long rounded = Math.round(money * 100);

        // Ganze Zahl in das gewünschte Format konvertieren
        double roundedNumber = (double) rounded / 100;

        return roundedNumber;
    }

    @RequestMapping("/api/currency/usdToEur/{money}")
    public Double usdToEur(@PathVariable Double money) {
        final double exchangeRate = 1.1;
        money= money/ exchangeRate;

        // Runden und das Ergebnis auf eine ganze Zahl casten
        long rounded = Math.round(money * 100);

        // Ganze Zahl in das gewünschte Format konvertieren
        double roundedNumber = (double) rounded / 100;

        return roundedNumber;
    }

}
