package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day09;

import java.util.ArrayList;
import java.util.List;

public class Map09 {

    protected int width;

    protected int height;

    protected Integer[][] values;

    public Map09(List<String> lines) {

        this.width = lines.get(0).length();
        this.height = lines.size();

        values = new Integer[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                try {
                    values[i][j] = Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
                } catch (Exception e) {
                    System.err.println();
                }
            }
        }
    }

    @Override
    public String toString() {

        return "Map09{" +
                "width=" + width +
                ", height=" + height +
                ", values:\n" + getMapString() +
                '}';
    }

    private String getMapString() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j != 0) {
                    result.append(", ");
                }
                result.append(values[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }

    public List<Integer> findLowPoints() {

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Integer lowPoint = processNode(i, j);
                if (null != lowPoint) {
                    result.add(lowPoint);
                }
            }
        }
        return result;
    }

    protected Integer processNode(int i, int j) {

        int value = values[i][j];
        List<Integer> neighbours = getNeighbours(i, j);
        for (Integer neighbour : neighbours) {
            if (neighbour <= value) {
                return null;
            }
        }
        return value;
    }

    protected List<Integer> getNeighbours(int yPosition, int xPosition) {

        List<Integer> result = new ArrayList<>();
        if (yPosition != 0) {
            result.add(values[yPosition - 1][xPosition]);
        }
        if (yPosition != height - 1) {
            result.add(values[yPosition + 1][xPosition]);
        }
        if (xPosition != 0) {
            result.add(values[yPosition][xPosition - 1]);
        }
        if (xPosition != width - 1) {
            result.add(values[yPosition][xPosition + 1]);
        }
        return result;
    }
}
