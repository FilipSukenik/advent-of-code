package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day07;

import java.util.HashMap;
import java.util.Map;

public class Submarine07 {

    private int position;

    private static final Map<Integer, Long> longMap = new HashMap<>();

    public Submarine07(String position) {

        this.position = Integer.parseInt(position);
    }

    public int getPosition() {

        return position;
    }

    public int getDelta(int newPosition) {

        return Math.abs(position - newPosition);
    }

    @Override
    public String toString() {

        return "" + position;
    }

    public Long getSpecialDelta(int newPosition) {

        int delta = getDelta(newPosition);
        return calculateSpecialDelta(delta);
    }

    private Long calculateSpecialDelta(int delta) {

        return longMap.computeIfAbsent(delta, this::calculateDelta);
    }

    private Long calculateDelta(int delta) {

        long deltaSum = 0L;
        for (int i = 1; i <= delta; i++) {
            deltaSum += i;
        }
        return deltaSum;
    }
}
