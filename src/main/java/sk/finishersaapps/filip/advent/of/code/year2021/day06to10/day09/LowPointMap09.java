package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day09;

import java.util.ArrayList;
import java.util.List;

public class LowPointMap09 extends Map09 {

    private final Point09[][] points;

    public LowPointMap09(List<String> lines) {

        super(lines);

        points = new Point09[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                points[i][j] = new Point09(j, i, values[i][j]);
            }
        }
    }

    public List<Point09> findLowPointsList() {

        List<Point09> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Integer lowPoint = processNode(i, j);
                if (null != lowPoint) {
                    result.add(points[i][j]);
                }
            }
        }
        return result;
    }

    public List<Basin09> getBasins() {

        List<Point09> lowPoints = findLowPointsList();
        List<Basin09> basins = new ArrayList<>();
        for (Point09 point : lowPoints) {
            basins.add(createBasinFromLowPoint(point));
        }
        return basins;
    }

    private Basin09 createBasinFromLowPoint(Point09 point) {

        List<Point09> unprocessedPoints = new ArrayList<>();
        unprocessedPoints.add(point);
        List<Point09> result = new ArrayList<>();
        while (!unprocessedPoints.isEmpty()) {
            Point09 poppedPoint = unprocessedPoints.remove(0);
            if (poppedPoint.isSearched()) {
                continue;
            }
            poppedPoint.setSearched(true);
            result.add(poppedPoint);
            List<Point09> neighbours = findNeighbours(poppedPoint);
            unprocessedPoints.addAll(neighbours);
        }

        return new Basin09(result);
    }

    private List<Point09> findNeighbours(Point09 poppedPoint) {

        int yPosition = poppedPoint.getY();
        int xPosition = poppedPoint.getX();

        List<Point09> result = new ArrayList<>();
        if (yPosition != 0) {
            if (!points[yPosition - 1][xPosition].isSearched()) {
                result.add(points[yPosition - 1][xPosition]);
            }
        }
        if (yPosition != height - 1) {
            if (!points[yPosition + 1][xPosition].isSearched()) {
                result.add(points[yPosition + 1][xPosition]);
            }
        }
        if (xPosition != 0) {
            if (!points[yPosition][xPosition - 1].isSearched()) {
                result.add(points[yPosition][xPosition - 1]);
            }
        }
        if (xPosition != width - 1) {
            if (!points[yPosition][xPosition + 1].isSearched()) {
                result.add(points[yPosition][xPosition + 1]);
            }
        }
        return result;
    }
}
