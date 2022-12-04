package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day10;

import java.util.HashMap;
import java.util.Map;

public class ErrorRate10 {

    private static final Character[] VALUES = {'}', ']', ')', '>'};

    private final Map<Character, Integer> errorsMap;

    public ErrorRate10() {

        errorsMap = new HashMap<>();

        for (Character value : VALUES) {
            errorsMap.put(value, 0);
        }
    }

    public void addCharacter(Character character) {

        Integer actualValue = errorsMap.get(character);
        actualValue += 1;
        errorsMap.put(character, actualValue);
    }

    @Override
    public String toString() {

        return "ErrorRate10{" +
                "errorsMap=" + errorsMap +
                '}';
    }

    public int getCount() {

        int sum = 0;
        for (Map.Entry<Character, Integer> entry : errorsMap.entrySet()) {
            sum += entry.getValue() * getCharValue(entry.getKey());
        }
        return sum;
    }

    private int getCharValue(Character key) {

        if (key.equals(')')) {
            return 3;
        }
        if (key.equals(']')) {
            return 57;
        }
        if (key.equals('}')) {
            return 1197;
        }
        if (key.equals('>')) {
            return 25137;
        }
        return 0;
    }
}
