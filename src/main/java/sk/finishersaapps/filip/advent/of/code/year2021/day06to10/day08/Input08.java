package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input08 {

    private List<String> inputs;

    private List<String> outputs;

    private List<String> allValues;

    private String[] numbers;

    public Input08(String line) {

        String[] splitLine = line.split(" \\| ");

        inputs = new ArrayList<>();
        outputs = new ArrayList<>();
        addToList(inputs, splitLine[0]);
        addToList(outputs, splitLine[1]);

        allValues = new ArrayList<>();

        allValues.addAll(inputs);
        allValues.addAll(outputs);

        numbers = new String[10];
    }

    private void addToList(List<String> list, String value) {

        String[] split = value.split(" ");

        for (String number : split) {
            List<Character> chars = new ArrayList<>();
            for (int i = 0; i < number.length(); i++) {
                chars.add(number.charAt(i));
            }
            chars.sort(Comparator.comparingInt(o -> o));
            StringBuilder resultString = new StringBuilder();
            for (Character character : chars) {
                resultString.append(character);
            }
            list.add(resultString.toString());
        }
    }

    public void explore() {

        for (String value : allValues) {
            int firstAnalysisValue = firstAnalysisOfValue(value);
            if (firstAnalysisValue == -1) {
                continue;
            }
            if (numbers[firstAnalysisValue] == null) {
                numbers[firstAnalysisValue] = value;
            }
        }

        find3(allValues);

        find9(allValues);

        char missingCharIn9 = findMissingChar8Minus9();

        find0(allValues, missingCharIn9);

        find6(allValues);

        find5(allValues, missingCharIn9);

        find2(allValues);

        System.out.println();
    }

    private void find2(List<String> allValues) {

        for (String value : allValues) {
            if (value.length() == 5 && !value.equals(numbers[5]) && !value.equals(numbers[3])) {
                numbers[2] = value;
                return;
            }
        }
        throw new RuntimeException("Did not find 5");
    }

    private void find5(List<String> allValues, char missingCharIn9) {

        for (String value : allValues) {
            if (value.length() == 5 && containsAllChars(numbers[6], value)
                    && !contains(value, missingCharIn9)) {
                numbers[5] = value;
                return;
            }
        }
        throw new RuntimeException("Did not find 5");

    }

    private boolean contains(String value, char missingCharIn9) {

        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == missingCharIn9) {
                return true;
            }
        }
        return false;
    }

    private void find6(List<String> allValues) {

        for (String value : allValues) {
            if (value.length() == 6 && !value.equals(numbers[0]) && !value.equals(numbers[9])) {
                numbers[6] = value;
                return;
            }
        }

        throw new RuntimeException("Did not find 6");
    }

    private void find0(List<String> allValues, char missingCharIn9) {

        for (String value : allValues) {
            if (value.length() == 6 && containsAllChars(value, numbers[7]) &&
                    containsAllChars(value, (String.valueOf(missingCharIn9)))) {
                numbers[0] = value;
                return;
            }
        }
        throw new RuntimeException("Did not find 0");
    }

    private char findMissingChar8Minus9() {

        Set<Character> eightChars = new HashSet<>();

        String eightString = numbers[8];

        for (int i = 0; i < eightString.length(); i++) {
            eightChars.add(eightString.charAt(i));
        }
        String nineString = numbers[9];
        for (int i = 0; i < nineString.length(); i++) {
            eightChars.remove(nineString.charAt(i));
        }

        return eightChars.stream().findFirst().get();
    }

    private void find9(List<String> allValues) {

        for (String value : allValues) {
            if (value.length() == 6 && containsAllChars(value, numbers[3])
                    && containsAllChars(value, numbers[4])) {
                numbers[9] = value;
                return;
            }
        }

        throw new RuntimeException("Did not find 9");
    }

    private void find3(List<String> allValues) {

        for (String value : allValues) {
            if (value.length() == 5 && containsAllChars(value, numbers[7])) {
                numbers[3] = value;
                return;
            }
        }

        throw new RuntimeException("Did not find 3");
    }

    public static Set<Character> stringToCharacterSet(String s) {

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    public static boolean containsAllChars
            (String container, String containee) {

        return stringToCharacterSet(container).containsAll
                (stringToCharacterSet(containee));
    }

    private int firstAnalysisOfValue(String value) {

        if (value.length() == 2) {
            return 1;
        }
        if (value.length() == 3) {
            return 7;
        }
        if (value.length() == 4) {
            return 4;
        }
        if (value.length() == 7) {
            return 8;
        }

        return -1;
    }

    public int sumAllNumbers() {

        int multiplier = 1000;
        int sum = 0;
        for (String output : outputs) {
            sum += getNumber(output) * multiplier;
            multiplier /= 10;
        }
        return sum;
    }

    private int getNumber(String output) {

        for (int i = 0; i < 10; i++) {
            if (output.equals(numbers[i])) {
                return i;
            }
        }
        return 0;
    }
}
