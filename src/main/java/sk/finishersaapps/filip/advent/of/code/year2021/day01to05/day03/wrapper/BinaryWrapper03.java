package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day03.wrapper;

public class BinaryWrapper03 {

    private int countOfZeros;

    private int countOfOnes;

    public int getCountOfZeros() {

        return countOfZeros;
    }

    public int getCountOfOnes() {

        return countOfOnes;
    }

    public void addCount(int value) {

        if (value == 1) {
            countOfOnes++;
        } else if (value == 0) {
            countOfZeros++;
        }
    }

    public int getTheMostCommon() {

        if (countOfOnes < countOfZeros) {
            return 0;
        } else {
            return 1;
        }
    }

    public void addChar(char character) {

        if (character == '1') {
            addCount(1);
        } else {
            addCount(0);
        }
    }

    @Override
    public String toString() {

        return "BinaryWrapper03{" +
                "countOfZeros=" + countOfZeros +
                ", countOfOnes=" + countOfOnes +
                '}';
    }

    public int getTheLeastCommon() {

        return Math.abs(getTheMostCommon() - 1);
    }

    public int getTheLeastCommonWithZero() {

        if (countOfOnes >= countOfZeros) {
            return 0;
        } else {
            return 1;
        }
    }
}
