package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day6;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.List;

public class Processor22_06 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/06/test.txt");

        lines.stream()
                .map(CommunicationReceiver::new)
                .mapToInt(receiver -> receiver.findStartingSequence(4))
                .forEach(System.out::println);

    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/06/test.txt");

        lines.stream()
                .map(CommunicationReceiver::new)
                .mapToInt(receiver -> receiver.findStartingSequence(14))
                .forEach(System.out::println);
    }
}
