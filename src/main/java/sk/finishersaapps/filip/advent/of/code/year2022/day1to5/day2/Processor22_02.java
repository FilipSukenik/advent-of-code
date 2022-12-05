package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Processor22_02 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/02/test.txt");

        int sum = lines.stream().map(Round::new).mapToInt(Round::resolve).sum();

        System.out.println(sum);
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/02/test.txt");
        int sum = lines.stream().map(EncryptedRound::new).mapToInt(Round::resolve).sum();

        System.out.println(sum);
    }
}
