package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day8;

public class Tree {

    private boolean isVisible = false;

    private int size;

    private int scenicScore;

    public Tree(int size) {
        this.size = size;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int getSize() {
        return size;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setScenicScore(int scenicScore) {
        this.scenicScore = scenicScore;
    }

    public int getScenicScore() {
        return scenicScore;
    }
}
