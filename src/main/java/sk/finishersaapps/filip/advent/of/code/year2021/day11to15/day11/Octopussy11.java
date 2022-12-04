package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day11;

public class Octopussy11 {

    private int value;

    private boolean flashed = false;

    private boolean processed = false;

    private int x;

    private int y;

    public Octopussy11(int x, int y, int value) {

        this.value = value;
        this.x = x;
        this.y = y;
    }

    public int getValue() {

        return value;
    }

    public boolean addValue() {

        if (flashed) {
            return false;
        }
        value++;
        if (value == 10) {
            value = 0;
            flashed = true;
            return true;
        }
        return false;
    }

    public boolean isFlashed() {

        return flashed;
    }

    public void setFlashed(boolean flashed) {

        this.flashed = flashed;
    }

    public void setValue(int value) {

        this.value = value;
    }

    public boolean isProcessed() {

        return processed;
    }

    public void setProcessed(boolean processed) {

        this.processed = processed;
    }

    public void reset() {

        flashed = false;
        processed = false;
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }

    @Override
    public String toString() {

        return "Octopussy11{" +
                "value=" + value +
                ", flashed=" + flashed +
                ", processed=" + processed +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
