package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

public class Node {

    private int x;

    private int y;

    public Node() {
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
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


    public void alterY(int change) {
        y += change;
    }

    public void alterX(int change) {
        x += change;
    }
}
