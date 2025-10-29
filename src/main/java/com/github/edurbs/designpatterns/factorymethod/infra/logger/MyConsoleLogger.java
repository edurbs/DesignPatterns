package com.github.edurbs.designpatterns.factorymethod.infra.logger;

import com.github.edurbs.designpatterns.factorymethod.application.ports.MyLogger;
import com.github.edurbs.designpatterns.factorymethod.infra.logger.output.Console;
import com.github.edurbs.designpatterns.factorymethod.application.ports.Output;

public class MyConsoleLogger implements MyLogger {
    @Override
    public Output createLogger() {
        return new Console();
    }
}
