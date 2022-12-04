package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day04;

import java.util.Arrays;
import java.util.List;

public class Board04 {

    private Number04[][] numbers;

    private boolean isWinning = false;

    public Board04(List<Integer> inputs) {

        numbers = new Number04[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                numbers[i][j] = new Number04(inputs.get(i * 5 + j));
            }
        }
    }

    public Number04[] addNumber(int number) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (numbers[i][j].getNumber() == number) {
                    numbers[i][j].setTagged(true);
                    Number04[] result = validate(i, j);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return null;
    }

    private Number04[] validate(int row, int column) {

        if (isFilled(row, true)) {
            isWinning = true;
            return extract(row, true);
        } else if (isFilled(column, false)) {
            isWinning = true;
            return extract(column, false);
        }
        return null;
    }

    private Number04[] extract(int position, boolean isRow) {

        Number04[] result = new Number04[5];
        if (isRow) {
            for (int i = 0; i < 5; i++) {
                result[i] = numbers[position][i];
            }
        } else {
            for (int i = 0; i < 5; i++) {
                result[i] = numbers[i][position];
            }
        }
        return result;
    }

    private boolean isFilled(int position, boolean isRow) {

        if (isRow) {
            for (int i = 0; i < 5; i++) {
                if (!numbers[position][i].isTagged()) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < 5; i++) {
                if (!numbers[i][position].isTagged()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {

        return "Board04{" +
                "numbers=" + Arrays.toString(numbers) +
                '}';
    }

    public void print() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%d\t", numbers[i][j].getNumber());
            }
            System.out.println();
        }
    }

    public int sumOfUntagged() {

        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!numbers[i][j].isTagged()) {
                    sum += numbers[i][j].getNumber();
                }
            }
        }
        return sum;
    }

    public boolean isWinning() {

        return isWinning;
    }
}
