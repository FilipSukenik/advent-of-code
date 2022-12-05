package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day10;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor10 extends Processor {

    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year21/10/input.txt");
        LineAnalyzer10 analyzer = new LineAnalyzer10();
        analyzer.analyze(lines);
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year21/10/input.txt");
        LineAnalyzer10 analyzer = new LineAnalyzer210();
        analyzer.analyze(lines);
    }
}
