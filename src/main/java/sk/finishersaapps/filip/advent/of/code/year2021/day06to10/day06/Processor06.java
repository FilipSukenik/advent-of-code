package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

public class Processor06 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/06/input.txt");
        List<Fish06> fish = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            for (String part : parts) {
                fish.add(new Fish06(part));
            }
        }
        for (int i = 1; i <= 80; i++) {
            List<Fish06> newborns = new ArrayList<>();
            for (Fish06 aliveFish : fish) {
                Fish06 newBorn = aliveFish.dayPassed();
                if (null != newBorn) {
                    newborns.add(newBorn);
                }
            }
            fish.addAll(newborns);
            //            System.out.printf("After %d day = %s%n", i, fish);
        }
        System.out.println("size = " + fish.size());
    }

    @Override
    public void secondTask() throws IOException {

        List<String> lines = getLines("year21/06/input.txt");
        List<Fish06> fish = new LinkedList<>();
        for (String line : lines) {
            String[] parts = line.split(",");
            for (String part : parts) {
                fish.add(new Fish06(part));
            }
        }
        FishMap06 valuesMap = new FishMap06();
        for (int i = -1; i < 9; i++) {
            valuesMap.put(i, 0L);
        }
        for (Fish06 actualFish : fish) {
            valuesMap.addValue(actualFish.getDays());
        }
        for (int i = 1; i <= 256; i++) {
            valuesMap.dayPassed();
            System.out.printf("size after %d days = %d %n", i, valuesMap.countFish());
        }
        System.out.println("size = " + fish.size());
    }
}
