package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day05;

import java.util.ArrayList;
import java.util.List;

public class Edge01 {

    private final Vertex05 source;

    private final Vertex05 destination;

    public Edge01(Vertex05 source, Vertex05 destination) {

        this.source = source;
        this.destination = destination;
    }

    public boolean isHorizontalOrVertical() {

        return source.hasOnePointSame(destination);
    }

    @Override
    public String toString() {

        return "Edge01{" +
                "source=" + source +
                ", destination=" + destination +
                '}';
    }

    public int max() {

        return Math.max(source.max(), destination.max());
    }

    public List<Vertex05> getPoints() {

        List<Vertex05> points = new ArrayList<>();
        if (source.getX() == destination.getX()) {
            if (source.getY() > destination.getY()) {
                for (int y = destination.getY(); y <= source.getY(); y++) {
                    points.add(new Vertex05(source.getX(), y));
                }
            } else {
                for (int y = source.getY(); y <= destination.getY(); y++) {
                    points.add(new Vertex05(source.getX(), y));
                }
            }
        } else if (source.getY() == destination.getY()) {
            if (source.getX() > destination.getX()) {
                for (int x = destination.getX(); x <= source.getX(); x++) {
                    points.add(new Vertex05(x, source.getY()));
                }
            } else {
                for (int x = source.getX(); x <= destination.getX(); x++) {
                    points.add(new Vertex05(x, source.getY()));
                }
            }
        } else {
            Edge01 normalizedEdge = getNormalizedEdge();
            int startingX = normalizedEdge.source.getX();
            if (normalizedEdge.source.getY() < normalizedEdge.destination.getY()) {
                for (int i = normalizedEdge.source.getY(); i <= normalizedEdge.destination.getY(); i++, startingX++) {
                    points.add(new Vertex05(startingX, i));
                }
            } else {
                for (int i = normalizedEdge.source.getY(); i >= normalizedEdge.destination.getY(); i--, startingX++) {
                    points.add(new Vertex05(startingX, i));
                }
            }
        }
        return points;
    }

    private Edge01 getNormalizedEdge() {

        if (source.getX() > destination.getX()) {
            return new Edge01(destination, source);
        }
        return this;
    }
}
