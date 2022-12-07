package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7;

public class CommandValue {

    private final Command command;

    private final String value;

    public CommandValue(Command command, String value) {
        this.command = command;
        this.value = value;
    }

    public CommandValue(Command command) {
        this.command = command;
        value = null;
    }

    public Command getCommand() {
        return command;
    }

    public String getValue() {
        return value;
    }

}
