package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Forest {

    private int height;

    private int width;

    private Tree[][] map;

    public Forest(List<String> lines) {
        height = lines.size();
        width = lines.get(0).length();
        map = new Tree[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                map[i][j] = new Tree(lines.get(i).charAt(j) - 48);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void calculateVisibility() {
        for (int i = 0; i < width; i++) {
            map[0][i].setVisible(true);
            map[map.length - 1][i].setVisible(true);
        }
        for (int i = 0; i < height; i++) {
            map[i][0].setVisible(true);
            map[i][width - 1].setVisible(true);
        }

        printMap();
        for (int i = 1; i < width - 1; i++) {
            int max = map[0][i].getSize();
            for (int j = 1; j < height - 1; j++) {
                if (max < map[j][i].getSize()) {
                    map[j][i].setVisible(true);
                    max = map[j][i].getSize();
                }
            }
        }

        printMap();
        for (int i = 1; i < width - 1; i++) {
            int max = map[height - 1][i].getSize();
            for (int j = height - 2; j > 0; j--) {
                if (max < map[j][i].getSize()) {
                    map[j][i].setVisible(true);
                    max = map[j][i].getSize();
                }
            }
        }

        printMap();

        for (int i = 1; i < height; i++) {
            int max = map[i][0].getSize();
            for (int j = 1; j < width - 1; j++) {
                if (max < map[i][j].getSize()) {
                    map[i][j].setVisible(true);
                    max = map[i][j].getSize();
                }
            }
        }

        printMap();

        for (int i = 1; i < height; i++) {
            int max = map[i][width - 1].getSize();
            for (int j = width - 2; j > 0; j--) {
                if (max < map[i][j].getSize()) {
                    map[i][j].setVisible(true);
                    max = map[i][j].getSize();
                }
            }
        }

        printMap();
    }

    public int getVisibleTreesCount() {

        int visible = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j].isVisible()) {
                    visible++;
                }
            }
        }
        return visible;
    }

    public void printMap() {
        if (true) {
            return;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.printf("[%s]", map[i][j].isVisible());
            }
            System.out.println();
        }
        System.out.println();
    }

    public int calculateScenicScore() {
        List<Tree> trees = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tree tree = map[i][j];
                trees.add(tree);
                calculateScenicScore(i, j);
            }
        }
        Optional<Tree> optional = trees.stream().max((o1, o2) -> o1.getScenicScore() - o2.getScenicScore());
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("This should not happen");
        }
        return optional.get().getScenicScore();
    }

    private void calculateScenicScore(int yPosition, int xPosition) {
        int left = lookLeft(yPosition, xPosition);
        int right = lookRight(yPosition, xPosition);
        int up = lookUp(yPosition, xPosition);
        int down = lookDown(yPosition, xPosition);
        int scenicScore = left * right * up * down;
        map[yPosition][xPosition].setScenicScore(scenicScore);
        System.out.println(scenicScore);
    }

    private int lookDown(int yPosition, int xPosition) {
        if (yPosition == height - 1) {
            return 0;
        }
        int size = map[yPosition][xPosition].getSize();
        int trees = 0;
        boolean sizeAchieved = false;
        for (int i = yPosition + 1; i < height; i++) {
            Tree lookingAt = map[i][xPosition];
            if (sizeAchieved) {
                break;
            }
            trees++;
            sizeAchieved = lookingAt.getSize() >= size;
        }
        return trees;
    }

    private int lookUp(int yPosition, int xPosition) {
        if (yPosition == 0) {
            return 0;
        }
        int size = map[yPosition][xPosition].getSize();
        int trees = 0;
        boolean sizeAchieved = false;
        for (int i = yPosition - 1; i >= 0; i--) {
            Tree lookingAt = map[i][xPosition];
            if (sizeAchieved) {
                break;
            }
            trees++;
            sizeAchieved = lookingAt.getSize() >= size;
        }
        return trees;
    }

    private int lookRight(int yPosition, int xPosition) {
        if (xPosition == width - 1) {
            return 0;
        }
        int size = map[yPosition][xPosition].getSize();
        int trees = 0;
        boolean sizeAchieved = false;
        for (int i = xPosition + 1; i < width; i++) {
            Tree lookingAt = map[yPosition][i];
            if (sizeAchieved) {
                break;
            }
            trees++;
            sizeAchieved = lookingAt.getSize() >= size;
        }
        return trees;
    }

    private int lookLeft(int yPosition, int xPosition) {
        if (xPosition == 0) {
            return 0;
        }
        int size = map[yPosition][xPosition].getSize();
        int trees = 0;
        boolean sizeAchieved = false;
        for (int i = xPosition - 1; i >= 0; i--) {
            Tree lookingAt = map[yPosition][i];
            if (sizeAchieved) {
                break;
            }
            trees++;
            sizeAchieved = lookingAt.getSize() >= size;
        }
        return trees;
    }
}
