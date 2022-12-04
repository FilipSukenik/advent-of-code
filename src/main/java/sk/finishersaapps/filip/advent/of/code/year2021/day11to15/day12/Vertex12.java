package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day12;

import java.util.ArrayList;
import java.util.List;

public class Vertex12 {

    private String name;

    private List<Edge12> edges;

    private boolean canBeUsedMultipleTimes;

    public Vertex12() {

        edges = new ArrayList<>();
    }

    public Vertex12(String name) {

        this.name = name;
        if(name.equals(name.toUpperCase())){
            canBeUsedMultipleTimes = true;
        }
        this.edges = new ArrayList<>();
    }

    public String getName() {

        return name;
    }

    public void addEdge(Edge12 edge) {

        edges.add(edge);
    }

    public List<Edge12> getEdges() {

        return edges;
    }

    @Override
    public String toString() {

        return "Vertex12{" +
                "name='" + name + '\'' +
                ", edges=" + edges +
                ", canBeUsedMultipleTimes=" + canBeUsedMultipleTimes +
                '}';
    }
}
