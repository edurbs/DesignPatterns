package com.github.edurbs.designpatterns.builder.application.domain;

import java.math.BigDecimal;

public class ProductItem {
    private final String name;
    private final int quantity;
    private final BigDecimal value;

    ProductItem(Builder builder){
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.value = builder.value;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public BigDecimal getValue(){
        return value;
    }

    public static class Builder{
        private String name;
        private int quantity;
        private BigDecimal value;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder quantity(int quantity){
            this.quantity=quantity;
            return this;
        }

        public Builder value(String value){
            if(value == null){
                throw new BusinessException("Value can't be null");
            }
            this.value = new BigDecimal(value);
            return this;
        }

        public Builder value(double value){
            this.value = BigDecimal.valueOf(value);
            return this;
        }

        public ProductItem build(){
            return new ProductItem(this);
        }
    }
}
