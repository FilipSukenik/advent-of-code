package sk.finishersaapps.filip.advent.of.code.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Processor {

    private static final String RESOURCES_PATH = "./src/main/resources/";

    public abstract void firstTask() throws IOException;

    public abstract void secondTask() throws IOException;

    protected List<String> getLines(String path) throws IOException {

        Path myPath = Paths.get(RESOURCES_PATH + path);
        return Files.readAllLines(myPath);
    }
}
