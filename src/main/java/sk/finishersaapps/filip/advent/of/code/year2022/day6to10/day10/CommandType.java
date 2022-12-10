package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day10;

import java.util.Arrays;
import java.util.Optional;

public enum CommandType {
    NOOP("noop"),
    ADD("addx");

    private final String name;

    CommandType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CommandType getByName(String name) {
        Optional<CommandType> firstFound = Arrays.stream(values()).filter(commandType -> commandType.name.equals(name)).findFirst();
        if (firstFound.isEmpty()) {
            throw new IllegalArgumentException("This should not happen");
        }
        return firstFound.get();
    }
}
