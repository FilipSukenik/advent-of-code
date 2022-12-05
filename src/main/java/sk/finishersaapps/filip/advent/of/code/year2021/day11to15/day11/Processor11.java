package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day11;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor11 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/11/input.txt");
        Map11 map = new Map11(lines);

        map.doSteps();
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/11/input.txt");
        Map11 map = new Map11(lines);

        map.doStepsUnlimitedSteps();
    }
}
