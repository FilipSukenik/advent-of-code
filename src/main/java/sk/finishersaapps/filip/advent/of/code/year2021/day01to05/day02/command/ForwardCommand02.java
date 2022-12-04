package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command;

import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.AimPositionWrapper02;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.PositionWrapper02;

public class ForwardCommand02 extends Command02 {

    @Override
    public void execute(PositionWrapper02 positionWrapper02, int value) {

        positionWrapper02.addHorizontalPosition(value);
    }

    @Override
    public void execute(AimPositionWrapper02 positionWrapper02, int value) {
        positionWrapper02.addHorizontalPosition(value);
        positionWrapper02.addDepth(value);
    }
}
