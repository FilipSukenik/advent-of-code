package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Path12 {

    private List<Vertex12> vertices;

    public Path12(List<Vertex12> vertices) {

        this.vertices = vertices;
    }

    public Path12(Vertex12 start) {

        this.vertices = new ArrayList<>();
        vertices.add(start);
    }

    public Path12 addToPath(Vertex12 vertex12) {

        List<Vertex12> newPath = new ArrayList<>(vertices);
        newPath.add(vertex12);
        return new Path12(newPath);
    }

    public Vertex12 getLast() {

        return vertices.get(vertices.size() - 1);
    }

    public boolean canVisitSpecial(Vertex12 destination) {

        for (Vertex12 vertex : vertices) {
            if (vertex.getName().equals(destination.getName()) &&
                    !vertex.getName().toUpperCase().equals(destination.getName())) {
                if (vertex.getName().equals("start") || vertex.getName().equals("end")) {
                    return false;
                }

                return verifySmallChars(destination.getName());
            }
        }
        return true;
    }

    private String findFirstLowercase() {

        for (Vertex12 vertex : vertices) {
            if (!vertex.getName().equals("start") && !vertex.getName().equals("end")) {
                if (!vertex.getName().toUpperCase().equals(vertex.getName())) {
                    return vertex.getName();
                }
            }
        }
        return null;
    }

    public boolean canVisit(Vertex12 destination) {

        for (Vertex12 vertex : vertices) {
            if (vertex.getName().equals(destination.getName()) &&
                    !vertex.getName().toUpperCase().equals(destination.getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < vertices.size(); i++) {
            if (i != 0) {
                result.append("->");
            }
            result.append(vertices.get(i).getName());
        }
        return result.append("\n").toString();
    }

    private boolean verifySmallChars(String name) {

        Map<String, Integer> counts = new HashMap<>();
        for (Vertex12 vertex : vertices) {
            counts.put(vertex.getName(), 0);
        }
        counts.put(name, 0);
        for (Vertex12 vertex : vertices) {
            if (!vertex.getName().toUpperCase().equals(vertex.getName())) {
                counts.put(vertex.getName(), counts.get(vertex.getName()) + 1);
            }
        }
        for (Integer value : counts.values()) {
            if (value == 2) {
                return false;
            }
        }

        return true;
    }
}