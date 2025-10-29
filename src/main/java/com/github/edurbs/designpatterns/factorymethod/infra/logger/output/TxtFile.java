package com.github.edurbs.designpatterns.factorymethod.infra.logger.output;

import com.github.edurbs.designpatterns.factorymethod.application.ports.Output;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TxtFile implements Output {
    @Override
    public void write(String string) {
        try {
            String filename = "src/main/resources/log.txt";
            Path filePath = Paths.get(filename);
            if (Files.notExists(filePath)) {
                Files.createDirectories(filePath.getParent());
                Files.createFile(filePath);
            }
            Files.writeString(
                    filePath,
                    string+"\n",
                    StandardOpenOption.APPEND
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
