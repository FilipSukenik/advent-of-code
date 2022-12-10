package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

import java.util.Arrays;
import java.util.Optional;

public enum Direction {
    LEFT("L"),
    RIGHT("R"),
    DOWN("D"),
    UP("U");

    private final String key;

    Direction(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public static Direction getByGey(String key) {
        Optional<Direction> first = Arrays.stream(values()).filter(direction -> direction.key.equals(key)).findFirst();

        if (first.isEmpty()) {
            throw new IllegalArgumentException("This should not happen");
        }
        return first.get();
    }
}
