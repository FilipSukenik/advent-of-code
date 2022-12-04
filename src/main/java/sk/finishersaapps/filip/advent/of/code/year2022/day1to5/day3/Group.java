package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day3;

public class Group {

    private String rucksack1;
    private String rucksack2;
    private String rucksack3;

    public Group(String rucksack1, String rucksack2, String rucksack3) {
        this.rucksack1 = rucksack1;
        this.rucksack2 = rucksack2;
        this.rucksack3 = rucksack3;
    }

    public int findValueOfSame() {
        for (int i = 0; i < rucksack1.length(); i++) {
            char actual = rucksack1.charAt(i);
            if (rucksack2.indexOf(actual) >= 0 && rucksack3.indexOf(actual) >= 0) {
                if (actual < 92) {
                    return actual - 38;
                }
                return actual - 96;
            }
        }
        return 0;
    }
}
