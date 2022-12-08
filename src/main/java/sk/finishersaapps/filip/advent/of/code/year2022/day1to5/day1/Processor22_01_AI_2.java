package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day1;

import java.util.Arrays;
import java.util.Scanner;

public class Processor22_01_AI_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] topThreeCalories = {0, 0, 0};

        int currentElfCalories = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                if (currentElfCalories > topThreeCalories[0]) {
                    topThreeCalories[0] = currentElfCalories;
                    Arrays.sort(topThreeCalories);
                }
                currentElfCalories = 0;
            } else {
                currentElfCalories += Integer.parseInt(line);
            }
        }

        if (currentElfCalories > topThreeCalories[0]) {
            topThreeCalories[0] = currentElfCalories;
            Arrays.sort(topThreeCalories);
        }

        int totalCalories = 0;
        for (int calories : topThreeCalories) {
            totalCalories += calories;
        }

        System.out.println(totalCalories);
    }
}
