package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day08;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor08 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/08/input.txt");
        List<String> values = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(" \\| ");
            String[] splitValues = splitLine[1].split(" ");
            values.addAll(Arrays.asList(splitValues));
        }
        Integer[] results = new Integer[8];
        Arrays.fill(results, 0);
        for (String value : values) {
            results[value.length()]++;
        }
        System.out.printf("Unique chars = %d%n", (results[2] + results[4] + results[3] + results[7]));
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/08/input.txt");
        Analyzer08 analyzer = new Analyzer08();
        analyzer.analyze(lines);
    }
}
