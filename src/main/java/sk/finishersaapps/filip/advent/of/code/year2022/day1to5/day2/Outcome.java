package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

import java.util.Arrays;

public enum Outcome {
    LOOSE("X"),
    DRAW("Y"),
    WIN("Z");

    private final String key;

    Outcome(String key) {
        this.key = key;
    }

    public static Outcome findByKey(String key) {
        return Arrays.stream(values())
                .filter(outcome -> outcome.key.equals(key))
                .findFirst()
                .get();
    }
}
