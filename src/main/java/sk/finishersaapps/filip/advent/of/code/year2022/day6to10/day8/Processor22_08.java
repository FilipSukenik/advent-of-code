package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day8;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.List;

public class Processor22_08 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/08/test.txt");

        Forest forest = new Forest(lines);
        forest.calculateVisibility();
        int visibleTrees = forest.getVisibleTreesCount();

        System.out.println(visibleTrees);
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/08/test.txt");

        Forest forest = new Forest(lines);
        System.out.println("max score = " + forest.calculateScenicScore());
    }
}
