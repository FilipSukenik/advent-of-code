package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day08;

import java.util.List;

public class Analyzer08 {

    public void analyze(List<String> lines) {

        int totalSum = 0;
        for (String line : lines) {
            Input08 input = new Input08(line);
            input.explore();
            int result = input.sumAllNumbers();
            totalSum += result;
            System.out.println("result is = " + result);
        }
        System.out.println("Absolute sum = " + totalSum);
    }
}
