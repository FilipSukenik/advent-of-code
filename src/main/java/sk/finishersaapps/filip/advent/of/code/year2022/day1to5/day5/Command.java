package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day5;

class Command {
    private int amount;

    private int from;

    private int to;

    public Command(String line) {
        String[] split = line.split(" ");
        amount = Integer.parseInt(split[1]);
        from = Integer.parseInt(split[3]) - 1;
        to = Integer.parseInt(split[5]) - 1;
    }

    public int getAmount() {
        return amount;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
