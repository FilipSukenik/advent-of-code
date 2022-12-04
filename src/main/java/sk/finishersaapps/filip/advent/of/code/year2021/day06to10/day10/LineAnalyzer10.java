package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day10;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LineAnalyzer10 {

    private final ErrorRate10 errorRate;

    private final List<BracketPair10> pairs;

    public LineAnalyzer10() {

        errorRate = new ErrorRate10();
        pairs = new ArrayList<>();
        pairs.add(new BracketPair10('{', '}'));
        pairs.add(new BracketPair10('(', ')'));
        pairs.add(new BracketPair10('[', ']'));
        pairs.add(new BracketPair10('<', '>'));
    }

    public void analyze(List<String> lines) {

        for (String line : lines) {
            analyze(line);
        }
        System.out.println(errorRate);
        System.out.println(errorRate.getCount());
    }

    public void analyze(String line) {

        Deque<Character> characters = new LinkedList<>();
        for (Character character : line.toCharArray()) {
            if (isStartingBracket(character)) {
                characters.add(character);
            } else if (isEndingBracket(character)) {
                if (characters.isEmpty()) {
                    //TODO non finished line
                } else {
                    Character lastChar = characters.pollLast();
                    if (!isPair(lastChar, character)) {
                        errorRate.addCharacter(character);
                    }
                }
            }
        }
    }

    protected boolean isPair(Character startingChar, Character endingChar) {

        for (BracketPair10 pair : pairs) {
            if (pair.compare(startingChar, endingChar)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isEndingBracket(Character character) {

        for (BracketPair10 pair : pairs) {
            if (pair.getEndingChar().equals(character)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isStartingBracket(Character character) {

        for (BracketPair10 pair : pairs) {
            if (pair.getStartingChar().equals(character)) {
                return true;
            }
        }
        return false;
    }
}
