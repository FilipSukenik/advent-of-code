package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day4;

class ElfSections {

    private int start;

    private int end;

    public ElfSections(String input) {
        String[] split = input.split("-");
        start = Integer.parseInt(split[0]);
        end = Integer.parseInt(split[1]);
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + "-" + end;
    }
}
