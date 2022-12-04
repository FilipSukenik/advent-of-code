package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day06;

public class Fish06 {

    private int days;

    public Fish06(String value) {

        days = Integer.parseInt(value);
    }

    public Fish06() {

        days = 8;
    }

    public Fish06 dayPassed() {

        days--;
        if (days < 0) {
            days = 6;
            return new Fish06();
        }
        return null;
    }

    @Override
    public String toString() {

        return "" + days;
    }

    public int getDays() {

        return days;
    }
}
