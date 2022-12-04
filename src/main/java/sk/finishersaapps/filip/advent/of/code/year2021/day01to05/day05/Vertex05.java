package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day05;

public class Vertex05 {

    private int x;

    private int y;

    public Vertex05(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Vertex05(String values) {

        String[] splitValues = values.split(",");
        try {
            x = Integer.parseInt(splitValues[0]);
            y = Integer.parseInt(splitValues[1]);
        } catch (Exception e) {
            System.out.println();
            throw new RuntimeException();
        }
    }

    public boolean hasOnePointSame(Vertex05 vertex) {

        return this.x == vertex.x || this.y == vertex.y;
    }

    @Override
    public String toString() {

        return "Vertex05{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public int max() {

        return Math.max(x, y);
    }

    public int getX() {

        return x;
    }

    public int getY() {

        return y;
    }
}

