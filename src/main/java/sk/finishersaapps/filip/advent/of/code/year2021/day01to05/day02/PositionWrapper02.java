package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02;

public class PositionWrapper02 {

    protected int horizontalPosition;

    protected int depth;

    public PositionWrapper02() {

    }

    public int getHorizontalPosition() {

        return horizontalPosition;
    }

    public int getDepth() {

        return depth;
    }

    public void addDepth(int addon) {

        depth += addon;
    }

    public void addHorizontalPosition(int addon) {

        horizontalPosition += addon;
    }

    @Override
    public String toString() {

        return "PositionWrapper02{" +
                "horizontalPosition=" + horizontalPosition +
                ", depth=" + depth +
                ", sum=" + (depth * horizontalPosition) +
                '}';
    }
}
