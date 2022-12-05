package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day13;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor13 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/13/input.txt");
        List<Dot13> dots = getDots(lines);
        List<Command13> commands = getCommands(lines);
        Analyzer13 analyzer = new Analyzer13();
        analyzer.analyze(dots, commands);
    }

    private List<Command13> getCommands(List<String> lines) {

        int i = 0;
        while (!lines.get(i).isEmpty()) {
            i++;
        }
        List<Command13> commands = new ArrayList<>();

        for (i++; i < lines.size(); i++) {
            commands.add(new Command13(lines.get(i)));
        }
        return commands;
    }

    private List<Dot13> getDots(List<String> lines) {

        List<Dot13> result = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                break;
            }
            result.add(new Dot13(line));
        }
        return result;
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/13/input.txt");
        List<Dot13> dots = getDots(lines);
        List<Command13> commands = getCommands(lines);
        System.out.println();
        Analyzer13 analyzer = new Analyzer213();
        analyzer.analyze(dots, commands);
    }
}
