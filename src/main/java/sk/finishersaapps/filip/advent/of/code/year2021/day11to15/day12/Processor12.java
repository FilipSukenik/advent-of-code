package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day12;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor12 extends Processor {

    @Override
    public void process0() throws IOException {

        List<String> lines = getLines("year21/12/input.txt");
        Analyzer12 analyzer = new Analyzer12();
        analyzer.analyze(lines);
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year21/12/input.txt");
        Analyzer12 analyzer = new Analyzer12();
        analyzer.analyze2(lines);
    }
}
