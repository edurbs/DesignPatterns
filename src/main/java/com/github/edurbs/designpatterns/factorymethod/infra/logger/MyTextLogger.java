package com.github.edurbs.designpatterns.factorymethod.infra.logger;

import com.github.edurbs.designpatterns.factorymethod.application.ports.MyLogger;
import com.github.edurbs.designpatterns.factorymethod.application.ports.Output;
import com.github.edurbs.designpatterns.factorymethod.infra.logger.output.TxtFile;

public class MyTextLogger implements MyLogger {

    @Override
    public Output createLogger() {
        return new TxtFile();
    }
}
