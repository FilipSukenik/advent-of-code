package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day3;

public class Rucksack {

    private String compartment1;

    private String compartment2;

    public Rucksack(String line) {

        int mid = line.length() / 2;
        compartment1 = line.substring(0, mid);
        compartment2 = line.substring(mid);
    }

    public int findValueOfSame() {
        char sameComponent = 0;
        end:
        for (int i = 0; i < compartment1.length(); i++) {
            for (int j = 0; j < compartment2.length(); j++) {
                if (compartment1.charAt(i) == compartment2.charAt(j)) {
                    sameComponent = compartment1.charAt(i);
                    break end;
                }
            }
        }
        if (sameComponent < 92) {
            return sameComponent - 38;
        }
        return sameComponent - 96;
    }
}
