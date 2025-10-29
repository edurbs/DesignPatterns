package com.github.edurbs.designpatterns.factorymethod.infra.logger.output;

import com.github.edurbs.designpatterns.factorymethod.application.ports.Output;

public class Console implements Output {

    @Override
    public void write(String string) {
        System.out.println(string);
    }
}
