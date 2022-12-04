package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LineAnalyzer210 extends LineAnalyzer10 {

    private List<Long> sums;

    public LineAnalyzer210() {

        sums = new ArrayList<>();
    }

    @Override
    public void analyze(String line) {

        Deque<Character> characters = new LinkedList<>();
        for (Character character : line.toCharArray()) {
            if (isStartingBracket(character)) {
                characters.add(character);
            } else if (isEndingBracket(character)) {
                if (characters.isEmpty()) {
                    break;
                } else {
                    Character lastChar = characters.pollLast();
                    if (!isPair(lastChar, character)) {
                        return;
                    }
                }
            }
        }

        if (characters.isEmpty()) {
            return;
        }
        System.out.println(characters);
        long actualSum = 0;
        List<Character> listChars = (LinkedList) characters;
        Collections.reverse(listChars);
        for (Character character : characters) {
            actualSum *= 5;
            actualSum += getValueOfChar(character);
        }
        System.out.println("actual sum = " + actualSum);
        sums.add(actualSum);
    }

    @Override
    public void analyze(List<String> lines) {

        super.analyze(lines);

        sums.sort(Comparator.comparingLong(o -> o));
        System.out.println("middle sum = " + sums.get(sums.size() / 2));
    }

    private int getValueOfChar(Character character) {

        if (character.equals('(')) {
            return 1;
        }
        if (character.equals('[')) {
            return 2;
        }
        if (character.equals('{')) {
            return 3;
        }
        if (character.equals('<')) {
            return 4;
        }
        return 0;
    }
}
