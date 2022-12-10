package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day10;

import java.util.List;

public class CrtCommandExecutor extends CommandExecutor {

    public CrtCommandExecutor(List<String> lines) {
        super(lines);
        xValue = 1;
    }

    @Override
    protected void executeCommand(Command command) {
        if (CommandType.NOOP == command.getCommandType()) {
            addActualCycle();
        } else if (CommandType.ADD == command.getCommandType()) {
            addActualCycle();
            addActualCycle();
            xValue += command.getAmount();
        }
    }

    private void addActualCycle() {
        System.out.print(isSpriteAtPosition() ? "#" : ".");
        actualCycle++;
        if (actualCycle == 40) {
            actualCycle = 0;
            System.out.println();
        }
    }

    private boolean isSpriteAtPosition() {
        return xValue - 1 == actualCycle || xValue == actualCycle || xValue + 1 == actualCycle;
    }
}