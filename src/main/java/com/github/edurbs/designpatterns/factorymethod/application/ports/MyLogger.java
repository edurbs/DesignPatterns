package com.github.edurbs.designpatterns.factorymethod.application.ports;

import java.time.LocalDateTime;

public interface MyLogger {
    default void log(String text){
        Output output = createLogger();
        String header = LocalDateTime.now().toString();
        output.write(header + " " + text);
    }

    Output createLogger();

}
