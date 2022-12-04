package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day13;

public class Dot13 {

    private int x;

    private int y;

    public Dot13(String input) {

        String[] splitInput = input.split(",");
        x = Integer.parseInt(splitInput[0]);
        y = Integer.parseInt(splitInput[1]);
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    @Override
    public String toString() {

        return "Dot13{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int getMax() {

        return Math.max(x, y);
    }
}
