package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandExecutor {

    private Map<Integer, Integer> additions;

    protected List<Command> commands;

    protected int xValue = 1;

    protected int actualCycle;

    int sumOfValuesAtCycles = 0;

    public CommandExecutor(List<String> lines) {

        commands = lines.stream().map(Command::new).collect(Collectors.toList());

        additions = new HashMap<>();
    }

    public void execute() {
        commands.forEach(this::executeCommand);
    }

    protected void executeCommand(Command command) {
        onCommandMiddle(command);

        onCommandEnd(command);
    }

    protected void onCommandMiddle(Command command) {

        if (CommandType.ADD == command.getCommandType()) {
            actualCycle++;
        }
        if (shouldBeAdded()) {
            add();
        }
    }

    private boolean shouldBeAdded() {
        return (actualCycle - 20) % 40 == 0;
    }

    protected void onCommandEnd(Command command) {
        actualCycle++;
        if (shouldBeAdded()) {
            add();
        }
        if (CommandType.ADD == command.getCommandType()) {
            xValue += command.getAmount();
        }
    }

    private void add() {
        additions.computeIfAbsent(actualCycle, c -> c * xValue);
    }

    public int getSum() {
        return additions.values().stream().mapToInt(integer -> integer).sum();
    }
}
