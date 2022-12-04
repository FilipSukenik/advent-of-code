package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day01;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor01 extends Processor {

    public void process0() throws IOException {

        int count = 0;
        int previousValue = -1;

        List<String> contents = getLines("year21/01/input.txt");
        for (String line : contents) {
            try {
                int value = Integer.parseInt(line);
                if (previousValue == -1) {
                    previousValue = value;
                    continue;
                }
                int delta = value - previousValue;
                if (delta > 0) {
                    count++;
                }
                previousValue = value;
            } catch (NumberFormatException e) {
                System.out.println("error");
            }
        }
        System.out.println("Number of increases = " + count);
    }

    public void process1() throws IOException {

        int count = 0;
        int previousValue = -1;
        List<String> contents = getLines("year21/01/input.txt");
        for (int i = 1; i < contents.size() - 1; i++) {
            int before = Integer.parseInt(contents.get(i - 1));
            int actual = Integer.parseInt(contents.get(i));
            int next = Integer.parseInt(contents.get(i + 1));
            int actualValue = before + actual + next;
            if (previousValue == -1) {
                previousValue = actualValue;
                continue;
            }
            int delta = actualValue - previousValue;
            if (delta > 0) {
                count++;
            }
            previousValue = actualValue;
        }
        System.out.println("Number of increases = " + count);
    }
}
