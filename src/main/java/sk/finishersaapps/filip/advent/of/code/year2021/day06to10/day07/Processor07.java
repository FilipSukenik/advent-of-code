package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day07;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor07 extends Processor {

    @Override
    public void process0() throws IOException {

        List<String> lines = getLines("year21/07/input.txt");
        List<Submarine07> submarines = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(",");
            for (String submarineValue : splitLine) {
                submarines.add(new Submarine07(submarineValue));
            }
        }
        int maxPosition = Integer.MIN_VALUE;
        for (Submarine07 submarine : submarines) {
            if (submarine.getPosition() > maxPosition) {
                maxPosition = submarine.getPosition();
            }
        }
        int minFuelConsumption = Integer.MAX_VALUE;
        for (int i = 0; i < maxPosition; i++) {
            int delta = 0;
            for (Submarine07 submarine : submarines) {
                delta += submarine.getDelta(i);
            }
            if (delta < minFuelConsumption) {
                minFuelConsumption = delta;
            }
        }
        System.out.printf("Min fuel needed = %d%n", minFuelConsumption);
    }

    @Override
    public void process1() throws IOException {
        List<String> lines = getLines("year21/07/input.txt");
        List<Submarine07> submarines = new ArrayList<>();
        for (String line : lines) {
            String[] splitLine = line.split(",");
            for (String submarineValue : splitLine) {
                submarines.add(new Submarine07(submarineValue));
            }
        }
        int maxPosition = Integer.MIN_VALUE;
        for (Submarine07 submarine : submarines) {
            if (submarine.getPosition() > maxPosition) {
                maxPosition = submarine.getPosition();
            }
        }
        int minFuelConsumption = Integer.MAX_VALUE;
        for (int i = 0; i < maxPosition; i++) {
            int delta = 0;
            for (Submarine07 submarine : submarines) {
                delta += submarine.getSpecialDelta(i);
            }
            if (delta < minFuelConsumption) {
                minFuelConsumption = delta;
            }
        }
        System.out.printf("Min fuel needed = %d%n", minFuelConsumption);
    }
}
