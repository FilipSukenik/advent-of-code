package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day10;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.List;

public class Processor22_10 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/10/test.txt");

        CommandExecutor executor = new CommandExecutor(lines);
        executor.execute();

        int result = executor.getSum();

        System.out.println(result);
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/10/test.txt");

        CommandExecutor executor = new CrtCommandExecutor(lines);
        executor.execute();
    }
}
