package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day05;

import java.util.ArrayList;
import java.util.List;

public class Map05 {

    private final Point05[][] points;

    private List<Vertex05> globalPoints;

    private final int size;

    public Map05(int size) {

        this.points = new Point05[size][size];

        globalPoints = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                points[i][j] = new Point05();
            }
        }

        this.size = size;
    }

    public void processEdges(List<Edge01> edges) {

        for (Edge01 edge : edges) {
            processEdge(edge);
        }
    }

    private void processEdge(Edge01 edge) {

        List<Vertex05> pointsOfEdge = edge.getPoints();
        globalPoints.addAll(pointsOfEdge);
//        System.out.println(edge);
        for (Vertex05 point : pointsOfEdge) {
            points[point.getX()][point.getY()].addNumberOfLines();
        }
//        printMap();
//        System.out.println();
    }

    public void printMap() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%d ", points[j][i].getNumberOfLines());
            }
            System.out.println();
        }
    }

    public int countMoreThan2() {

        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (points[i][j].getNumberOfLines() > 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
