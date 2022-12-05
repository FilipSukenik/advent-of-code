package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor04 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/04/input.txt");
        String[] calledNumbersStrings = lines.get(0).split(",");
        List<Integer> inputs = new ArrayList<>();
        List<Board04> boards = new ArrayList<>();
        for (String numberString : calledNumbersStrings) {
            inputs.add(Integer.parseInt(numberString));
        }

        for (int i = 1; i < lines.size(); ) {
            i++;
            List<Integer> boardInput = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String[] boardLineSplit = lines.get(i).split(" ");
                for (String s : boardLineSplit) {
                    if ("".equals(s)) {
                        continue;
                    }
                    boardInput.add(Integer.parseInt(s));
                }
                i++;
            }
            boards.add(new Board04(boardInput));
        }

        for (Board04 board : boards) {
            board.print();
            System.out.println();
        }

        for (Integer input : inputs) {
            System.out.println("input = " + input);
            for (Board04 board : boards) {
                Number04[] winningLine = board.addNumber(input);
                if (null != winningLine) {
                    int winningLineSum = board.sumOfUntagged();
                    System.out.printf("Sum = %d, number =%d, multiplied = %d%n", winningLineSum, input, input * winningLineSum);
                    return;
                }
            }
        }
    }

    private int sumWinningLine(Number04[] winningLine) {

        int sum = 0;
        for (Number04 number04 : winningLine) {
            sum += number04.getNumber();
        }
        return sum;
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/04/input.txt");
        String[] calledNumbersStrings = lines.get(0).split(",");
        List<Integer> inputs = new ArrayList<>();
        List<Board04> boards = new ArrayList<>();
        for (String numberString : calledNumbersStrings) {
            inputs.add(Integer.parseInt(numberString));
        }

        for (int i = 1; i < lines.size(); ) {
            i++;
            List<Integer> boardInput = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String[] boardLineSplit = lines.get(i).split(" ");
                for (String s : boardLineSplit) {
                    if ("".equals(s)) {
                        continue;
                    }
                    boardInput.add(Integer.parseInt(s));
                }
                i++;
            }
            boards.add(new Board04(boardInput));
        }

        for (Board04 board : boards) {
            board.print();
            System.out.println();
        }

        Board04 lastBoard = null;

        for (Integer input : inputs) {
            for (int i = 0; i < boards.size(); i++) {
                boards.get(i).addNumber(input);
                if (boards.get(i).isWinning()) {
                    lastBoard = boards.remove(i);
                    i--;
                }
                if (boards.size() == 0) {
                    int winningLineSum = lastBoard.sumOfUntagged();
                    System.out.printf("Sum = %d, number = %d, multiplied = %d%n", winningLineSum, input, input * winningLineSum);
                    return;
                }
            }
        }
    }
}
