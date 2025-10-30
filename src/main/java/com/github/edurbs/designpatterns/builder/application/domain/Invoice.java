package com.github.edurbs.designpatterns.builder.application.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private final int number;
    private final Date date;
    private final List<ProductItem> productList;
    private final Person person;

    public Invoice(Builder builder){
        this.number = builder.number;
        this.date = builder.date;
        this.productList = builder.productList;
        this.person = builder.person;
    }

    public BigDecimal calculateTax(){
        return person.calculateTax(getValueTotal());
    }

    public BigDecimal getValueTotal(){
        return productList.stream()
                .map(ProductItem::getValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public int getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public List<ProductItem> getProductList() {
        return productList;
    }

    public Person getPerson(){
        return person;
    }

    public static class Builder{
        private int number;
        private Date date;
        private final List<ProductItem> productList = new ArrayList<>();
        private Person person;

        public Builder number(int number){
            this.number = number;
            return this;
        }

        public Builder date(String dateString){
            if(dateString==null){
                throw new BusinessException("Date can't be null!");
            }
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
                this.date = format.parse(dateString);
            } catch (ParseException _) {
                throw new IllegalArgumentException("Invalid date");
            }
            return this;
        }

        public Builder addItem(ProductItem productItem){
            this.productList.add(productItem);
            return this;
        }

        public Builder person(Person person){
            this.person = person;
            return this;
        }

        public Invoice build(){
            return new Invoice(this);
        }
    }
}
