package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7;

import java.io.File;

public class Line {

    private boolean isCommand;

    private String line;

    public Line(String line) {

        this.line = line;
        if (line.startsWith("$")) {
            isCommand = true;
        }
    }

    public CommandValue toCommand() {
        String[] split = line.split(" ");
        if ("cd".equals(split[1])) {
            return new CommandValue(Command.CD, split[2]);
        }
        return new CommandValue(Command.LS);
    }

    public MyFile toFile() {
        String[] split = line.split(" ");
        if ("dir".equals(split[0])) {
            MyFile file = new MyFile();
            file.setName(split[1]);
            file.setDirectory(true);
            return file;
        }
        MyFile file = new MyFile();
        file.setSize(Long.parseLong(split[0]));
        file.setName(split[1]);
        return file;
    }

    public boolean isCommand() {
        return isCommand;
    }

    public String getLine() {
        return line;
    }
}
