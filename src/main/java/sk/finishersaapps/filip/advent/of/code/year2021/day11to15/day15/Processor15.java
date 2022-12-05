package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day15;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor15 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/15/input.txt");
        Map15 map = new Map15(lines);

        Analyzer15 analyzer15 = new Analyzer15();
        analyzer15.analyse(map);
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/15/input.txt");
        Map15 map = new Map215(lines);
        System.out.println();
        Analyzer15 analyzer15 = new Analyzer15();
        analyzer15.analyse(map);
    }
}
