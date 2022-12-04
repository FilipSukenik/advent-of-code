package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day15;

import java.util.List;

public class Map15 {

    protected Node15[][] nodes;

    protected int width;

    protected int height;

    protected boolean visited;

    public Map15() {

    }

    public Map15(List<String> lines) {

        height = lines.size();
        width = lines.get(0).length();
        nodes = new Node15[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                nodes[i][j] = new Node15(j, i, Integer.parseInt(String.valueOf(lines.get(i).charAt(j))));
            }
        }
    }

    public Node15[][] getNodes() {

        return nodes;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {

        return height;
    }

    public Node15 getStart() {

        return nodes[0][0];
    }

    public Node15 getEnd() {

        return nodes[height - 1][width - 1];
    }

    public boolean isVisited() {

        return visited;
    }

    public void setVisited(boolean visited) {

        this.visited = visited;
    }

    public Node15 getCandidate(Candidate15 candidate) {

        return nodes[candidate.getY()][candidate.getX()];
    }
}
