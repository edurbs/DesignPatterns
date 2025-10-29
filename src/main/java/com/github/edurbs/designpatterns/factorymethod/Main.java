package com.github.edurbs.designpatterns.factorymethod;

import com.github.edurbs.designpatterns.factorymethod.application.ports.MyLogger;
import com.github.edurbs.designpatterns.factorymethod.application.TaxCalculator;
import com.github.edurbs.designpatterns.factorymethod.infra.logger.MyConsoleLogger;

public class Main {
    static void main() {
        MyLogger myLogger = new MyConsoleLogger();
        TaxCalculator taxCalculator = new TaxCalculator(myLogger);
        taxCalculator.calc(2);
        taxCalculator.calc(4);
        taxCalculator.calc(8);
    }
}
