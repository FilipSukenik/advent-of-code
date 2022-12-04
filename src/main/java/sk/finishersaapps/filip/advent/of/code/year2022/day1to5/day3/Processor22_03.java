package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day3;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Processor22_03 extends Processor {
    @Override
    public void process0() throws IOException {
        List<String> lines = getLines("year22/03/test.txt");

        int sum = lines.stream().map(line -> new Rucksack(line).findValueOfSame())
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year22/03/test.txt");

        int sum = 0;
        for (int i = 0; i < lines.size(); i++) {
            Group group = new Group(lines.get(i++), lines.get(i++), lines.get(i));
            sum += group.findValueOfSame();
        }
        System.out.println(sum);
    }
}
