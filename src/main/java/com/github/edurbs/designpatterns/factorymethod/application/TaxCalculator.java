package com.github.edurbs.designpatterns.factorymethod.application;

import com.github.edurbs.designpatterns.factorymethod.application.ports.MyLogger;

import java.math.BigDecimal;

public class TaxCalculator {

    private final MyLogger myLogger;

    public TaxCalculator(MyLogger myLogger){
        this.myLogger = myLogger;
    }

    public void calc(double value){
        BigDecimal taxed = BigDecimal.valueOf(value).multiply(BigDecimal.TWO);
        myLogger.log("Tax calculate: R$ %,.2f".formatted(taxed));
    }
}
