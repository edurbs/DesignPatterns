package com.github.edurbs.designpatterns.builder.application.domain;

import java.math.BigDecimal;

public enum Person {
    INDIVIDUAL {
        @Override
        public BigDecimal calculateTax(BigDecimal amount){
            return amount.multiply(BigDecimal.valueOf(1.07));
        }
    },
    COMPANY {
        @Override
        public BigDecimal calculateTax(BigDecimal amount) {
            return amount.multiply(BigDecimal.valueOf(1.04));
        }
    };
    public abstract BigDecimal calculateTax(BigDecimal amount);
}
