package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day10;

public class BracketPair10 {

    private Character startingChar;

    private Character endingChar;

    public BracketPair10(Character startingChar, Character endingChar) {

        this.startingChar = startingChar;
        this.endingChar = endingChar;
    }

    public Character getStartingChar() {

        return startingChar;
    }

    public Character getEndingChar() {

        return endingChar;
    }

    public boolean compare(Character startingChar, Character endingChar) {

        return startingChar == this.startingChar && endingChar == this.endingChar;
    }
}
