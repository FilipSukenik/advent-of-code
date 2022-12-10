package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day9;

public class Move {

    private Direction direction;
    private int amount;

    public Move(String line) {
        String[] split = line.split(" ");
        direction = Direction.getByGey(split[0]);
        amount = Integer.parseInt(split[1]);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
