package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day04;

public class Number04 {

    private final int number;

    private boolean isTagged = false;

    public Number04(int number) {

        this.number = number;
    }

    public int getNumber() {

        return number;
    }

    public boolean isTagged() {

        return isTagged;
    }

    public void setTagged(boolean tagged) {

        isTagged = tagged;
    }

    @Override
    public String toString() {

        return "Number04{" +
                "number=" + number +
                '}';
    }
}
