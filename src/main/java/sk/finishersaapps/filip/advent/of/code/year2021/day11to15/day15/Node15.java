package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node15 {

    private final int x;

    private final int y;

    private final int value;

    private boolean isVisited;

    private int distance = Integer.MAX_VALUE;

    public Node15(int x, int y, int value) {

        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    public int getValue() {

        return value;
    }

    public boolean isVisited() {

        return isVisited;
    }

    public void setVisited(boolean visited) {

        isVisited = visited;
    }

    public List<Candidate15> toCandidates() {

        List<Candidate15> result = new ArrayList<>();
        result.add(new Candidate15(x - 1, y));
        result.add(new Candidate15(x + 1, y));
        result.add(new Candidate15(x, y - 1));
        result.add(new Candidate15(x, y + 1));

        return result;
    }

    public void addDistance(int distance) {

        distance += value;
        if (distance < this.distance) {
            this.distance = distance;
        }
    }

    public void setDistance(int distance) {

        this.distance = distance;
    }

    public int getDistance() {

        return distance;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Node15 node15 = (Node15) o;
        return getX() == node15.getX() && getY() == node15.getY();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {

        return "Node15{" +
                "x=" + x +
                ", y=" + y +
                ", value=" + value +
                ", isVisited=" + isVisited +
                ", distance=" + distance +
                '}';
    }
}
