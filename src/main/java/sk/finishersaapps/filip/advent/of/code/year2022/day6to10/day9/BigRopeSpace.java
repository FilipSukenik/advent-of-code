package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

import java.util.List;

public class BigRopeSpace extends RopeSpace {

    private Node[] middles;

    public BigRopeSpace(List<String> lines) {
        super(lines);
        middles = new Node[8];
        for (int i = 0; i < 8; i++) {
            middles[i] = new Node(startingPosition, startingPosition);
        }
    }

    @Override
    protected void checkTail() {

        checkNodes(head, middles[0]);
        for (int i = 0; i < middles.length - 1; i++) {
            checkNodes(middles[i], middles[i + 1]);
        }
        checkNodes(middles[middles.length - 1], tail);

        map[tail.getY()][tail.getX()].setVisited(true);
//        System.out.printf("[%d][%d]%n", tail.getX(), tail.getY());
    }

    private void checkNodes(Node head, Node tail) {
        int xDiff = head.getX() - tail.getX();
        int yDiff = head.getY() - tail.getY();

        if (Math.abs(xDiff) > 2 || Math.abs(yDiff) > 2) {
            System.out.printf("problemo %d, %d%n", xDiff, yDiff);
        }
        if (Math.abs(xDiff) > 1 && Math.abs(yDiff) > 1) {
            tail.alterX(xDiff / 2);
            tail.alterY(yDiff / 2);
        } else if (Math.abs(xDiff) > 1) {
            tail.alterX(xDiff / 2);
            tail.alterY(yDiff);
        } else if (Math.abs(yDiff) > 1) {
            tail.alterY(yDiff / 2);
            tail.alterX(xDiff);
        }
    }
}
