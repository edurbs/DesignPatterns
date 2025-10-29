package com.github.edurbs.designpatterns.factorymethod.application;

import com.github.edurbs.designpatterns.factorymethod.application.ports.MyLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TaxCalculatorTest {

    @Mock
    MyLogger myLogger;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @InjectMocks
    TaxCalculator sut;

    @Test
    void givenValue_whenCalculate_thenWriteDoubleValue() {
        double value = 1000;
        sut.calc(value);
        verify(myLogger).log(stringArgumentCaptor.capture());
        String expected = "Tax calculate: R$ 2.000,00";
        assertEquals(expected, stringArgumentCaptor.getValue());
    }
}