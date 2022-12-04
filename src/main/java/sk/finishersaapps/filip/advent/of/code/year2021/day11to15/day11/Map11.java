package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day11;

import java.util.ArrayList;
import java.util.List;

public class Map11 {

    private final Octopussy11[][] octopussies;

    public Map11(List<String> lines) {

        octopussies = new Octopussy11[10][10];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                octopussies[i][j] = new Octopussy11(j, i, Integer.parseInt(Character.valueOf(lines.get(i).charAt(j)).toString()));
            }
        }
    }

    public void doSteps() {

        printMap();
        System.out.println();
        int flashes = 0;
        for (int i = 0; i < 100; i++) {
            flashes += doStep();
            printMap();
            System.out.println();
        }

        System.out.println("total c=number of flashes = " + flashes);
    }

    public void doStepsUnlimitedSteps() {

        printMap();
        System.out.println();
        int i = 0;
        while (true) {
            int flashes = doStep();
            i++;
            if (flashes == 100) {
                System.out.println("ended in " + i + " rounds");
                return;
            }
            printMap();
            System.out.println();
        }
    }

    private int doStep() {

        int flashes = 0;
        List<Octopussy11> octopussiesToProcess = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (octopussies[i][j].addValue()) {
                    octopussiesToProcess.add(octopussies[i][j]);
                }
            }
        }

        while (!octopussiesToProcess.isEmpty()) {
            Octopussy11 processedOctopussy = octopussiesToProcess.remove(0);
            if (processedOctopussy.isProcessed()) {
                continue;
            }
            if (!processedOctopussy.isFlashed()) {
                if (processedOctopussy.addValue()) {
                    octopussiesToProcess.add(processedOctopussy);
                }
                continue;
            }
            processedOctopussy.setProcessed(true);
            flashes++;
            List<Octopussy11> neighbours = findNeighbours(processedOctopussy);

            for (Octopussy11 neighbour : neighbours) {
                if (neighbour.isProcessed()) {
                    continue;
                }
                if (neighbour.addValue()) {
                    octopussiesToProcess.add(neighbour);
                }
            }
        }
        resetAllOctopussies();
        return flashes;
    }

    private List<Octopussy11> findNeighbours(Octopussy11 processedOctopussy) {

        List<Octopussy11> result = new ArrayList<>();
        for (int i = processedOctopussy.getY() - 1; i <= processedOctopussy.getY() + 1; i++) {
            for (int j = processedOctopussy.getX() - 1; j <= processedOctopussy.getX() + 1; j++) {
                if (i == processedOctopussy.getY() && j == processedOctopussy.getX()) {
                    continue;
                }
                Octopussy11 neighbour = getNeighbour(i, j);
                if (null != neighbour) {
                    result.add(neighbour);
                }
            }
        }
        return result;
    }

    private Octopussy11 getNeighbour(int y, int x) {

        try {
            return octopussies[y][x];
        } catch (Exception e) {
            return null;
        }
    }

    private void resetAllOctopussies() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                octopussies[i][j].reset();
            }
        }
    }

    public void printMap() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(octopussies[i][j].getValue());
            }
            System.out.println();
        }
    }
}