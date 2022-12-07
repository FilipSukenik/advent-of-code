package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day7;

import sk.finishersaapps.filip.advent.of.code.common.Processor;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Processor22_07 extends Processor {
    @Override
    public void firstTask() throws IOException {
        List<String> lines = getLines("year22/07/test.txt");

        List<Line> dataLines = lines.stream().map(Line::new).collect(Collectors.toList());

        MyFile root = createStructure(dataLines);

        root.calculateSize();
        System.out.println(root.findSizeOfDirsAtMost(100_000));
    }

    private MyFile createStructure(List<Line> dataLines) {

        MyFile root = new MyFile();
        root.setName("/");
        root.setDirectory(true);

        MyFile actualDirectory = root;

        for (int i = 1; i < dataLines.size(); i++) {
            Line line = dataLines.get(i);
            if (line.isCommand()) {
                CommandValue command = line.toCommand();
                if (Command.LS == command.getCommand()) {
                    i++;
                    if (i >= dataLines.size()) {
                        break;
                    }
                    line = dataLines.get(i);
                    while (!line.isCommand()) {
                        MyFile file = line.toFile();
                        actualDirectory.addFile(file);
                        file.setParent(actualDirectory);
                        i++;
                        if (i >= dataLines.size()) {
                            break;
                        }
                        line = dataLines.get(i);
                    }
                    i--;
                } else if (Command.CD == command.getCommand()) {
                    actualDirectory = actualDirectory.findDir(command.getValue());
                }
            }
        }
        return root;
    }

    @Override
    public void secondTask() throws IOException {
        List<String> lines = getLines("year22/07/test.txt");

        List<Line> dataLines = lines.stream().map(Line::new).collect(Collectors.toList());

        MyFile root = createStructure(dataLines);

        root.calculateSize();

        long rootSize = root.getSize();

        long freeSpace = 70_000_000 - rootSize;

        long needToFreeUp = 30_000_000 - freeSpace;

        List<MyFile> candidates = root.getAllDirsWithMinSize(needToFreeUp);
        candidates.add(root);
        Optional<MyFile> toDelete = candidates.stream()
                .min((o1, o2) -> (int) (o1.getSize() - o2.getSize()));
        System.out.println(toDelete.get().getName());
    }
}
