package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day4;

import sk.finishersaapps.filip.advent.of.code.common.Processor;
import sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day3.Group;
import sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day3.Rucksack;

import java.io.IOException;
import java.util.List;

public class Processor22_04 extends Processor {
    @Override
    public void process0() throws IOException {
        List<String> lines = getLines("year22/04/test.txt");

        long amount = lines.stream()
                .map(ElfPair::new)
                .filter(ElfPair::containEachOther)
                .count();
        System.out.println(amount);
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year22/04/test.txt");

        long amount = lines.stream()
                .map(ElfPair::new)
                .filter(ElfPair::overlap)
                .count();
        System.out.println(amount);
    }
}
