package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day1;

import java.util.Scanner;

public class Processor22_01_AI {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxCalories = 0;
        int currentElfCalories = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.isEmpty()) {
                maxCalories = Math.max(maxCalories, currentElfCalories);
                currentElfCalories = 0;
            } else {
                currentElfCalories += Integer.parseInt(line);
            }
        }

        maxCalories = Math.max(maxCalories, currentElfCalories);
        System.out.println(maxCalories);
    }


}
