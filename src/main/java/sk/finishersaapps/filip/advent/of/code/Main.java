package sk.finishersaapps.filip.advent.of.code;

import sk.finishersaapps.filip.advent.of.code.common.Processor;
import sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day5.Processor22_05;
import sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day6.Processor22_06;
import sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7.Processor22_07;
import sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day8.Processor22_08;
import sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9.Processor22_09;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Processor processor = new Processor22_09();
        processor.secondTask();
    }
}
