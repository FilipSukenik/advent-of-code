package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day5;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Processor22_05 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/05/test.txt");

        int emptyLineIndex = findEmptyLine(lines);

        System.out.println("empty line = " + emptyLineIndex);

        List<String> boxesLines = lines.subList(0, emptyLineIndex);
        Collections.reverse(boxesLines);

        OptionalInt maxOpt = Arrays.stream(
                        boxesLines.get(0).strip().replaceAll("\\s+", " ").split(" "))
                .mapToInt(Integer::parseInt)
                .max();

        if (maxOpt.isEmpty()) {
            throw new IllegalArgumentException("max could not be found");
        }

        int max = maxOpt.getAsInt();

        List<Stack<String>> stacks = getStacks(max, boxesLines);

        List<Command> commandsList = lines.subList(emptyLineIndex, lines.size())
                .stream().map(Command::new).collect(Collectors.toList());

        commandsList.forEach(command -> {
            for (int i = 0; i < command.getAmount(); i++) {
                String popped = stacks.get(command.getFrom()).pop();
                stacks.get(command.getTo()).push(popped);
            }
        });
        List<String> topBoxes = new ArrayList<>();
        stacks.forEach(stack ->
                topBoxes.add(stack.peek())
        );

        String topBoxesString = topBoxes.stream().map(box -> box.substring(1, 2)).collect(Collectors.joining());


        System.out.println(topBoxesString);
    }

    private List<Stack<String>> getStacks(int max, List<String> boxesLines) {
        List<Stack<String>> stacks = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            stacks.add(new Stack<>());
        }

        boxesLines.remove(0);

        List<List<String>> boxesData = boxesLines.stream().map(line -> {
            List<String> boxes = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                boxes.add(line.substring(i, i + 3));
                i += 3;
            }
            return boxes;
        }).collect(Collectors.toList());

        boxesData.forEach(lineBoxes -> {
                    for (int i = 0; i < lineBoxes.size(); i++) {
                        if (lineBoxes.get(i).contains("[")) {
                            stacks.get(i).push(lineBoxes.get(i));
                        }
                    }
                }
        );
        return stacks;
    }

    private int findEmptyLine(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if ("".equals(lines.get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/05/test.txt");

        int emptyLineIndex = findEmptyLine(lines);

        System.out.println("empty line = " + emptyLineIndex);

        List<String> boxesLines = lines.subList(0, emptyLineIndex);
        Collections.reverse(boxesLines);

        OptionalInt maxOpt = Arrays.stream(
                        boxesLines.get(0).strip().replaceAll("\\s+", " ").split(" "))
                .mapToInt(Integer::parseInt)
                .max();

        if (maxOpt.isEmpty()) {
            throw new IllegalArgumentException("max could not be found");
        }

        int max = maxOpt.getAsInt();

        List<Stack<String>> stacks = getStacks(max, boxesLines);

        List<Command> commandsList = lines.subList(emptyLineIndex, lines.size())
                .stream().map(Command::new).collect(Collectors.toList());

        commandsList.forEach(command -> {
            List<String> popped = new ArrayList<>();
            for (int i = 0; i < command.getAmount(); i++) {
                popped.add(stacks.get(command.getFrom()).pop());
            }
            Collections.reverse(popped);
            popped.forEach(box ->
                    stacks.get(command.getTo()).push(box)
            );
        });
        List<String> topBoxes = new ArrayList<>();
        stacks.forEach(stack ->
                topBoxes.add(stack.peek())
        );

        String topBoxesString = topBoxes.stream().map(box -> box.substring(1, 2)).collect(Collectors.joining());


        System.out.println(topBoxesString);
    }
}
