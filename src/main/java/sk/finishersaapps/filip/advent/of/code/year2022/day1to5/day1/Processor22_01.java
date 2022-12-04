package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day1;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Processor22_01 extends Processor {
    @Override
    public void process0() throws IOException {
        List<String> lines = getLines("year22/01/test.txt");
        List<Integer> values = new ArrayList<>();
        int i = 0;
        values.add(0);
        for (String line : lines) {
            try {
                int actualValue = Integer.parseInt(line);
                int stored = values.get(i);
                values.set(i, stored + actualValue);
            } catch (Exception e) {
                i++;
                values.add(0);
            }
        }

        System.out.println(values.stream().max(
                Comparator.comparingInt(o -> o)
        ));
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year22/01/test.txt");
        List<Integer> values = new ArrayList<>();
        int i = 0;
        values.add(0);
        for (String line : lines) {
            try {
                int actualValue = Integer.parseInt(line);
                int stored = values.get(i);
                values.set(i, stored + actualValue);
            } catch (Exception e) {
                i++;
                values.add(0);
            }
        }

        System.out.println(values.stream()
                .sorted((o1, o2) -> o2 - o1)
                .limit(3)
                .reduce(0, Integer::sum));
    }
}
