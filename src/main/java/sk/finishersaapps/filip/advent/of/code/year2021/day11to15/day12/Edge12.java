package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day12;

public class Edge12 {

    private Vertex12 source;

    private Vertex12 destination;

    public Edge12(Vertex12 source, Vertex12 destination) {

        this.source = source;
        this.destination = destination;
    }

    public Vertex12 getSource() {

        return source;
    }

    public Vertex12 getDestination() {

        return destination;
    }

    @Override
    public String toString() {

        return "Edge12{" +
                "source=" + source.getName() +
                ", destination=" + destination.getName() +
                '}';
    }
}
