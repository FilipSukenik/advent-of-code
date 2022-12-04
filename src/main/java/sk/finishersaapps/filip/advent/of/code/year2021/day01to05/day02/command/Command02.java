package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command;

import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.AimPositionWrapper02;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.PositionWrapper02;

public abstract class Command02 {

    public abstract void execute(PositionWrapper02 positionWrapper02, int value);

    public abstract void execute(AimPositionWrapper02 positionWrapper02, int value);
}
