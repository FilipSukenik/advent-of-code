package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7;

public enum Command {
    CD("cd"),
    LS("ls");

    private final String name;


    Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
