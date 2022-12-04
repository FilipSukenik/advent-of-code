package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day05;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor05 extends Processor {

    @Override
    public void process0() throws IOException {

        List<Edge01> edges = readEdges("year21/05/input.txt");
        int size = findMax(edges) + 1;
        filterEdges(edges);
        Map05 map = new Map05(size);
        map.processEdges(edges);
        System.out.println("number of dangerous zones = " + map.countMoreThan2());
    }

    private int findMax(List<Edge01> edges) {

        int max = Integer.MIN_VALUE;
        for (Edge01 edge : edges) {
            int localMax = edge.max();
            if (localMax > max) {
                max = localMax;
            }
        }
        return max;
    }

    private void filterEdges(List<Edge01> edges) {

        for (int i = 0; i < edges.size(); i++) {
            if (!edges.get(i).isHorizontalOrVertical()) {
                edges.remove(i);
                i--;
            }
        }
    }

    private List<Edge01> readEdges(String path) throws IOException {

        List<String> lines = getLines(path);
        List<Edge01> result = new ArrayList<>();
        int i = 0;
        for (String line : lines) {
            i++;
            String[] splitLine = line.split(" -> ");
            try {
                Vertex05 source = createVertex(splitLine[0]);
                Vertex05 destination = createVertex(splitLine[1]);
                result.add(new Edge01(source, destination));
            } catch (RuntimeException e) {
                System.out.println();
            }
        }
        return result;
    }

    private Vertex05 createVertex(String values) {

        return new Vertex05(values);
    }

    @Override
    public void process1() throws IOException {

        List<Edge01> edges = readEdges("year21/05/input.txt");
        int size = findMax(edges) + 1;

        Map05 map = new Map05(size);
        map.processEdges(edges);
//        map.printMap();
        System.out.println("number of dangerous zones = " + map.countMoreThan2());
    }
}
