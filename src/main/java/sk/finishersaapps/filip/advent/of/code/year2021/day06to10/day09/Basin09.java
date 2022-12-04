package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day09;

import java.util.List;

public class Basin09 {

    private List<Point09> points;

    public Basin09(List<Point09> points) {

        this.points = points;
    }

    public List<Point09> getPoints() {

        return points;
    }

    public int getPointsSum() {

        return points.size();
    }
}
