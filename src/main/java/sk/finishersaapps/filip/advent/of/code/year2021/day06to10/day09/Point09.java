package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day09;

public class Point09 {

    private int x;

    private int y;

    private int value;

    private boolean isSearched;

    public Point09(int x, int y, int value) {

        this.x = x;
        this.y = y;
        this.value = value;
        if (value == 9) {
            isSearched = true;
        }
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {

        this.x = x;
    }

    public int getY() {

        return y;
    }

    public void setY(int y) {

        this.y = y;
    }

    public boolean isSearched() {

        return isSearched;
    }

    public void setSearched(boolean searched) {

        isSearched = searched;
    }

    public int getValue() {

        return value;
    }
}
