package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

import java.util.Arrays;

public enum Hand {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    private final String key1;
    private final String key2;
    private final int value;

    Hand(String key1, String key2, int value) {
        this.key1 = key1;
        this.key2 = key2;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Hand getByKeys(String key) {
        return Arrays.stream(values())
                .filter(hand -> key.equals(hand.key1) || key.equals(hand.key2))
                .findFirst()
                .get();
    }
}
