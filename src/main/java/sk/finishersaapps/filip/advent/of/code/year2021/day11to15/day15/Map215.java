package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day15;

import java.util.ArrayList;
import java.util.List;

public class Map215 extends Map15 {

    public Map215(List<String> originalLines) {

        List<String> lines = new ArrayList<>();
        for (String line : originalLines) {
            StringBuilder newLine = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                newLine.append(line);
            }
            lines.add(newLine.toString());
        }
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < originalLines.size(); i++) {
                lines.add(lines.get(i));
            }
        }

        height = originalLines.size() * 5;
        width = originalLines.get(0).length() * 5;
        nodes = new Node15[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int leftOffset = (j) / originalLines.get(0).length();
                int topOffset = (i) / originalLines.size();
                int value = leftOffset + topOffset + Integer.parseInt(String.valueOf(lines.get(i).charAt(j)));
                while (value > 9) {
                    value = value - 9;
                }
                nodes[i][j] = new Node15(j, i, value);
            }
        }
    }
}
