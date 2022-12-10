package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.List;

public class Processor22_09 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/09/test.txt");

        RopeSpace space = new RopeSpace(lines);
        space.executeMoves();
        int visited = space.countVisited();
        System.out.println(visited);
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year22/09/test.txt");

        RopeSpace space = new BigRopeSpace(lines);
        space.executeMoves();
        space.printMap();
        int visited = space.countVisited();
        System.out.println(visited);
    }
}
