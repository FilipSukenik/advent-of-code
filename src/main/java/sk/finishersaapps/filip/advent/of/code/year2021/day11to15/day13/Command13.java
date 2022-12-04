package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day13;

public class Command13 {

    private int position;

    private String axes;

    public Command13(String input) {

        input = input.replace("fold along ", "");
        String[] splitInput = input.split("=");
        axes = splitInput[0];

        position = Integer.parseInt(splitInput[1]);
    }

    public int getPosition() {

        return position;
    }

    public String getAxes() {

        return axes;
    }

    @Override
    public String toString() {

        return "Command13{" +
                "position=" + position +
                ", axes='" + axes + '\'' +
                '}';
    }
}
