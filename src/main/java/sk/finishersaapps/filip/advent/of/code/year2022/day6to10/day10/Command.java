package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day10;

public class Command {

    private CommandType commandType;

    private int amount;

    public Command(String line) {
        String[] split = line.split(" ");
        commandType = CommandType.getByName(split[0]);
        if (CommandType.ADD == commandType) {
            amount = Integer.parseInt(split[1]);
        }
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public int getAmount() {
        return amount;
    }
}
