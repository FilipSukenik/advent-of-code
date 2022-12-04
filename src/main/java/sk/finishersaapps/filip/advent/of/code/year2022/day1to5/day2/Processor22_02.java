package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Processor22_02 extends Processor {
    @Override
    public void process0() throws IOException {
        List<String> lines = getLines("year22/02/test.txt");

        int sum = 0;
        for (String line : lines) {
            Round round = new Round(line);
            sum += round.resolve();
        }

        System.out.println(sum);
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year22/02/test.txt");
        int sum = 0;
        for (String line : lines) {
            Round round = new EncryptedRound(line);
            sum += round.resolve();
        }

        System.out.println(sum);
    }
}
