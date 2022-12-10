package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RopeSpace {

    protected static final int SIZE = 1000;

    protected RopeNode[][] map;

    protected List<Move> moves;

    protected Node head;

    protected Node tail;

    private int visited;

    int startingPosition;

    public RopeSpace(List<String> lines) {
        map = new RopeNode[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = new RopeNode();
            }
        }

        startingPosition = SIZE / 2;
        moves = lines.stream().map(Move::new).collect(Collectors.toList());
        head = new Node(startingPosition, startingPosition);
        tail = new Node(startingPosition, startingPosition);
    }

    public void executeMoves() {
        map[tail.getY()][tail.getX()].setVisited(true);

        moves.forEach(this::executeMove);
    }

    private void executeMove(Move move) {
        for (int i = 0; i < move.getAmount(); i++) {
            switch (move.getDirection()) {
                case DOWN:
                    head.alterY(1);
                    checkTail();
                    break;
                case UP:
                    head.alterY(-1);
                    checkTail();
                    break;
                case LEFT:
                    head.alterX(-1);
                    checkTail();
                    break;
                case RIGHT:
                    head.alterX(1);
                    checkTail();
                    break;
            }
        }
    }

    protected void checkTail() {
        int xDiff = head.getX() - tail.getX();
        int yDiff = head.getY() - tail.getY();
        if (Math.abs(xDiff) > 1) {
            tail.alterX(xDiff / 2);
            tail.alterY(yDiff);
        } else if (Math.abs(yDiff) > 1) {
            tail.alterY(yDiff / 2);
            tail.alterX(xDiff);
        }
        map[tail.getY()][tail.getX()].setVisited(true);
    }

    public int countVisited() {
        if (0 == visited) {
            Arrays.stream(map).forEach(line -> Arrays.stream(line)
                    .forEach(node -> {
                                if (node.isVisited()) {
                                    visited++;
                                }
                            }
                    ));
        }
        return visited;
    }

    public void printMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j].isVisited() ? "#" : ".");
            }
            System.out.println();
        }
        System.out.println();
    }
}
