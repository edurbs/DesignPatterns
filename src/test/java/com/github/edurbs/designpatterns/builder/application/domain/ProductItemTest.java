package com.github.edurbs.designpatterns.builder.application.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductItemTest {

    @Test
    void givenValueAsString_whenSetValue_thenConvertToBigDecimal(){
        ProductItem productItemUnderTest = createProductItemWithoutValue()
                .value("10.00")
                .build();
        assertEquals(0, BigDecimal.TEN.compareTo(productItemUnderTest.getValue()));
    }

    @Test
    void givenNullValue_whenSetValue_thenThrowException(){
        Executable build = () -> createProductItemWithoutValue()
                .value(null)
                .build();
        assertThrows(BusinessException.class, build);
    }

    @Test
    void givenValueAsDouble_whenSetValue_thenConvertToBigDecimal(){
        ProductItem productItemUnderTest = createProductItemWithoutValue()
                .value(10D)
                .build();
        assertEquals(0, BigDecimal.TEN.compareTo(productItemUnderTest.getValue()));
    }

    public static ProductItem.Builder createProductItemWithoutValue() {
        return new ProductItem.Builder()
                .name("Item 1")
                .quantity(1);
    }

}
