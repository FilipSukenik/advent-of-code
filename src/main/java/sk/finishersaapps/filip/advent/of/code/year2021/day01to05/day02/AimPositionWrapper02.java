package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02;

public class AimPositionWrapper02 extends PositionWrapper02 {

    private int aim;

    public AimPositionWrapper02() {

    }

    public int getAim() {

        return aim;
    }

    public void addAim(int addon) {

        aim += addon;
    }

    @Override
    public void addDepth(int addon) {

        depth += (aim * addon);
    }
}
