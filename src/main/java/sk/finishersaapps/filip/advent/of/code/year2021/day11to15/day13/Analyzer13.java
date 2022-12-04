package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day13;

import java.util.List;

public class Analyzer13 {

    public void analyze(List<Dot13> dots, List<Command13> commands) {

        int width = findMaxX(dots) + 1;
        int height = findMaxY(dots) + 1;
        String[][] map = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = ".";
            }
        }
        for (Dot13 dot : dots) {
            map[dot.getY()][dot.getX()] = "#";
        }

        executeLogic(map, commands);
    }

    protected void executeLogic(String[][] map, List<Command13> commands) {

        String[][] foldedMap = executeFold(map, commands.get(0));

        System.out.println("total count of dots = " + countDots(foldedMap));
    }

    protected int countDots(String[][] map) {

        int count = 0;
        for (String[] strings : map) {
            for (String string : strings) {
                if ("#".equals(string)) {
                    count++;
                }
            }
        }
        return count;
    }

    public String[][] executeFold(String[][] map, Command13 command13) {

        if (command13.getAxes().equals("y")) {
            return foldMapY(map, command13.getPosition());
        } else {
            return foldMapX(map, command13.getPosition());
        }
    }

    private String[][] foldMapY(String[][] map, int position) {

        String[][] result = new String[map.length / 2][map[0].length];
        int delta = 0;
        if (map.length % 2 == 0) {
            delta = -1;
        }
        for (int i = 0; i < map.length / 2 + delta; i++) {
            for (int j = 0; j < map[i].length; j++) {
                result[position - 1 - i][j] = mergeDots(map[position + 1 + i][j], map[position - 1 - i][j]);
            }
        }
        return result;
    }

    private String mergeDots(String merger1, String merger2) {

        if ("#".equals(merger1) || "#".equals(merger2)) {
            return "#";
        }
        return ".";
    }

    private String[][] foldMapX(String[][] map, int position) {

        String[][] result = new String[map.length][map[0].length / 2];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length / 2; j++) {
                result[i][j] = mergeDots(map[i][position - 1 - j], map[i][position + 1 + j]);
            }
        }
        return result;
    }

    private int findMaxX(List<Dot13> dots) {

        int max = Integer.MIN_VALUE;
        for (Dot13 dot : dots) {
            max = Math.max(max, dot.getX());
        }
        return max;
    }

    private int findMaxY(List<Dot13> dots) {

        int max = Integer.MIN_VALUE;
        for (Dot13 dot : dots) {
            max = Math.max(max, dot.getY());
        }
        return max;
    }

    protected void drawMap(String[][] map) {

        for (String[] strings : map) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int findMax(List<Dot13> dots) {

        int max = Integer.MIN_VALUE;
        for (Dot13 dot : dots) {
            int localMax = dot.getMax();
            max = Math.max(max, localMax);
        }
        return max;
    }
}
