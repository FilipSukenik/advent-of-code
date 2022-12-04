package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Analyzer12 {

    Map<String, Vertex12> verticesMap = new HashMap<>();

    public void analyze(List<String> lines) {

        readInput(lines);

        findPaths(verticesMap);
    }

    public void analyze2(List<String> lines) {

        readInput(lines);

        findPaths2(verticesMap);
    }

    private void readInput(List<String> lines) {

        for (String line : lines) {
            String[] splitLine = line.split("-");
            Vertex12 first = new Vertex12(splitLine[0]);
            Vertex12 second = new Vertex12(splitLine[1]);

            verticesMap.putIfAbsent(first.getName(), first);
            verticesMap.putIfAbsent(second.getName(), second);

            Edge12 edge = new Edge12(first, second);
            Edge12 edge1 = new Edge12(second, first);

            verticesMap.get(first.getName()).addEdge(edge);
            verticesMap.get(second.getName()).addEdge(edge1);
        }
    }

    private void findPaths(Map<String, Vertex12> verticesMap) {

        Vertex12 start = verticesMap.get("start");

        findAllPaths(start);
    }

    private void findPaths2(Map<String, Vertex12> verticesMap) {

        Vertex12 start = verticesMap.get("start");

        findAllPaths2(start);
    }

    private void findAllPaths(Vertex12 start) {

        List<Path12> paths = new ArrayList<>();
        List<Path12> result = new ArrayList<>();
        paths.add(new Path12(start));
        while (!paths.isEmpty()) {
            Path12 path = paths.remove(0);
            Vertex12 vertex = verticesMap.get(path.getLast().getName());
            for (Edge12 edge : vertex.getEdges()) {
                if (edge.getDestination().getName().equals("end")) {
                    result.add(path.addToPath(verticesMap.get(edge.getDestination().getName())));
                    continue;
                }
                if (path.canVisit(edge.getDestination())) {
                    paths.add(path.addToPath(verticesMap.get(edge.getDestination().getName())));
                }
            }
        }
        System.out.println("amount of paths = " + result.size());
    }

    private void findAllPaths2(Vertex12 start) {

        List<Path12> paths = new ArrayList<>();
        List<Path12> result = new ArrayList<>();
        paths.add(new Path12(start));
        while (!paths.isEmpty()) {
            Path12 path = paths.remove(0);
            Vertex12 vertex = verticesMap.get(path.getLast().getName());
            for (Edge12 edge : vertex.getEdges()) {
                if (edge.getDestination().getName().equals("end")) {
                    result.add(path.addToPath(verticesMap.get(edge.getDestination().getName())));
                    continue;
                }
                if (path.canVisitSpecial(edge.getDestination())) {
                    paths.add(path.addToPath(verticesMap.get(edge.getDestination().getName())));
                }
            }
        }
        System.out.println("amount of paths = " + result.size());
    }
}
