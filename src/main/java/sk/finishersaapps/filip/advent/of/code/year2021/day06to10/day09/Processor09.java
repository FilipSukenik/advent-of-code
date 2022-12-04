package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day09;

import java.io.IOException;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor09 extends Processor {

    @Override
    public void process0() throws IOException {

        List<String> lines = getLines("year21/09/input.txt");
        Map09 map = new Map09(lines);
        List<Integer> lowPoints = map.findLowPoints();
        int sum = 0;
        for (Integer lowPoint : lowPoints) {
            sum += lowPoint + 1;
        }

        System.out.println(sum);
    }

    @Override
    public void process1() throws IOException {

        List<String> lines = getLines("year21/09/input.txt");
        LowPointMap09 map = new LowPointMap09(lines);
        List<Basin09> basins = map.getBasins();
        int sum = 1;
        basins.sort((o1, o2) -> o2.getPointsSum() - o1.getPointsSum());
        for (int i = 0; i < 3 && i < basins.size(); i++) {
            sum *= basins.get(i).getPointsSum();
        }
        System.out.println("basin sum = " + sum);
    }
}
