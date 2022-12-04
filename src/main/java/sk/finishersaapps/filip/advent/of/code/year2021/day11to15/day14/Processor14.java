package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day14;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor14 extends Processor {

    @Override
    public void process0() throws IOException {

        List<String> lines = getLines("year21/14/test.txt");

        Map<String, Rule14> ruleMap = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            try {
                Rule14 rule = new Rule14(lines.get(i));
                ruleMap.put(rule.getSource(), rule);
            } catch (Exception e) {
                System.out.println();
            }
        }

        execute(10, ruleMap, lines.get(0));
    }

    private void execute(int retries,
            Map<String, Rule14> ruleMap, String sourceString) throws IOException {

        for (int j = 0; j < retries; j++) {
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < sourceString.length() - 1; i++) {
                String substring = sourceString.substring(i, i + 2);
                resultString.append(substring.charAt(0));
                Rule14 rule = ruleMap.get(substring);
                if (null != rule) {
                    resultString.append(rule.getAddition());
                }
                if (i == sourceString.length() - 2) {
                    resultString.append(sourceString.charAt(i + 1));
                }
            }
            sourceString = resultString.toString();
            System.out.printf("After %d tries length = %d%n", j + 1, sourceString.length());
        }
        calculate(sourceString);
    }

    private void calculate(String sourceString) {

        Map<Character, Long> charsMap = new HashMap<>();
        for (char character : sourceString.toCharArray()) {
            charsMap.putIfAbsent(character, 0L);
            charsMap.put(character, charsMap.get(character) + 1);
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (Long value : charsMap.values()) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        System.out.println("The number = " + (max - min));
    }

    @Override
    public void process1() throws IOException {

        List<String> lines = getLines("year21/14/input.txt");

        Map<String, Rule14> ruleMap = new HashMap<>();
        for (int i = 2; i < lines.size(); i++) {
            try {
                Rule14 rule = new Rule14(lines.get(i));
                ruleMap.put(rule.getSource(), rule);
            } catch (Exception e) {
                System.out.println();
            }
        }

        executeSpecial(ruleMap, lines.get(0));
    }

    private void executeSpecial(Map<String, Rule14> ruleMap, String startString) {

        Map<Character, Long> actualLettersCount = new HashMap<>();

        Map<String, Long> pairsCount = new HashMap<>();

        addPairsToMap(pairsCount, startString);
        addCharactersToMap(actualLettersCount, startString);

        //        for (int i = 0; i < 10; i++) {

        for(int i = 0; i < 40; i++){
            Map<String, Long> newPairs = new HashMap<>();
            for (Map.Entry<String, Long> entry : pairsCount.entrySet()) {
                Rule14 rule = ruleMap.get(entry.getKey());
                if (null != rule) {
                    addCharacterToMap(actualLettersCount, rule.getAddition(), entry.getValue());
                    addPairsToMap(rule.toPairs(), newPairs, entry.getValue());
                }
            }
            pairsCount = newPairs;
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (Long value : actualLettersCount.values()) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        System.out.println("The number = " + (max - min));
        //        }
    }

    private void addPairsToMap(List<String> pairs, Map<String, Long> newPairs, Long value) {

        for (int i = 0; i < pairs.size(); i++) {
            newPairs.putIfAbsent(pairs.get(i), 0L);
            newPairs.put(pairs.get(i), newPairs.get(pairs.get(i)) + value);
        }
    }

    private void addCharacterToMap(Map<Character, Long> actualLettersCount, String addition, Long value) {

        char character = addition.charAt(0);
        actualLettersCount.putIfAbsent(character, 0L);
        actualLettersCount.put(character, actualLettersCount.get(character) + value);
    }

    private void addPairsToMap(Map<String, Long> pairsCount, String startString) {

        for (int i = 0; i < startString.length() - 1; i++) {
            String substring = startString.substring(i, i + 2);
            pairsCount.putIfAbsent(substring, 0L);
            pairsCount.put(substring, pairsCount.get(substring) + 1);
        }

    }

    private void addCharactersToMap(Map<Character, Long> actualLettersCount, String additionString) {

        for (char character : additionString.toCharArray()) {
            actualLettersCount.putIfAbsent(character, 0L);
            actualLettersCount.put(character, actualLettersCount.get(character) + 1);
        }
    }
}
