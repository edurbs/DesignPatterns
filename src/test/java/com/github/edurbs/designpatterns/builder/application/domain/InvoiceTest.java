package com.github.edurbs.designpatterns.builder.application.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InvoiceTest {

    @Test
    void givenDateAsString_whenSetData_thenConvertToExpectedDate() {
        LocalDate localDate = LocalDate.of(2025, 12, 30);
        ZoneId zone = ZoneId.systemDefault();
        Date expectedDate = Date.from(localDate.atStartOfDay(zone).toInstant());
        Invoice invoiceUnderTest = createInvoice().build();
        assertEquals(expectedDate, invoiceUnderTest.getDate());
    }

    @Test
    void givenNullDate_whenSetDate_thenThrowException(){
        Executable build = () ->  createInvoice()
                .date(null)
                .build();
        assertThrows(BusinessException.class, build);
    }

    @Test
    void givenValidCompanyInvoice_whenCalculateTax_thenApply4Percent(){
        Invoice invoiceUnderTest = createInvoice()
                .person(Person.COMPANY)
                .build();
        BigDecimal taxExpected = BigDecimal.valueOf(104D);
        BigDecimal calculatedTax = invoiceUnderTest.calculateTax();
        assertEquals(0, taxExpected.compareTo(calculatedTax));
    }

    @Test
    void givenValidIndividualInvoice_whenCalculateTax_thenApply7Percent(){
        Invoice invoiceUnderTest = createInvoice()
                .person(Person.INDIVIDUAL)
                .build();
        BigDecimal taxExpected = BigDecimal.valueOf(107D);
        BigDecimal calculatedTax = invoiceUnderTest.calculateTax();
        assertEquals(0, taxExpected.compareTo(calculatedTax));
    }

    private Invoice.Builder createInvoice(){
        ProductItem productItem = new ProductItem.Builder()
                .name("item 1")
                .value(100)
                .build();
        return new Invoice.Builder()
                .number(1)
                .person(Person.INDIVIDUAL)
                .date("30/12/2025")
                .addItem(productItem);
    }


}