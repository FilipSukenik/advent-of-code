package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day13;

import java.util.List;

public class Analyzer213 extends Analyzer13 {

    @Override
    protected void executeLogic(String[][] map, List<Command13> commands) {

        String[][] foldedMap = executeFold(map, commands.get(0));
        for (int i = 1; i < commands.size(); i++) {
            foldedMap = executeFold(foldedMap, commands.get(i));
        }

        drawMap(foldedMap);

        System.out.println("total count of dots = " + countDots(foldedMap));

    }
}
