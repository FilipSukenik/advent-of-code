package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day4;

import java.util.stream.IntStream;

public class ElfPair {

    private ElfSections first;

    private ElfSections second;

    public ElfPair(String line) {
        String[] split = line.split(",");
        first = new ElfSections(split[0]);
        second = new ElfSections(split[1]);
    }

    public boolean containEachOther() {
        return (first.getStart() <= second.getStart() &&
                first.getEnd() >= second.getEnd()) ||
                (second.getStart() <= first.getStart() &&
                        second.getEnd() >= first.getEnd());
    }

    public boolean overlap() {

        return IntStream.rangeClosed(first.getStart(), first.getEnd())
                .anyMatch(value -> value == second.getStart() ||
                        value == second.getEnd()) ||
                IntStream.rangeClosed(second.getStart(), second.getEnd())
                        .anyMatch(value -> value == first.getStart() ||
                                value == first.getEnd());
    }

    @Override
    public String toString() {
        return "ElfPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
