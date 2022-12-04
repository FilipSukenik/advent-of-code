package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sk.finishersaapps.filip.advent.of.code.common.Processor;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command.Command02;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command.DownCommand02;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command.ForwardCommand02;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day02.command.UpCommand02;

public class Processor02 extends Processor {

    @Override
    public void process0() throws IOException {

        Map<String, Command02> commandMap = new HashMap<>();
        commandMap.put("forward", new ForwardCommand02());
        commandMap.put("up", new UpCommand02());
        commandMap.put("down", new DownCommand02());

        PositionWrapper02 positionWrapper = new PositionWrapper02();

        List<String> commands = getLines("year21/02/input.txt");
        for (String command : commands) {
            String[] split = command.split(" ");
            Command02 pickedCommand = commandMap.get(split[0]);
            pickedCommand.execute(positionWrapper, Integer.parseInt(split[1]));
        }


    }

    @Override
    public void process1() throws IOException {
        Map<String, Command02> commandMap = new HashMap<>();
        commandMap.put("forward", new ForwardCommand02());
        commandMap.put("up", new UpCommand02());
        commandMap.put("down", new DownCommand02());
        AimPositionWrapper02 positionWrapper = new AimPositionWrapper02();

        List<String> commands = getLines("year21/02/input.txt");
        for (String command : commands) {
            String[] split = command.split(" ");
            Command02 pickedCommand = commandMap.get(split[0]);
            pickedCommand.execute(positionWrapper, Integer.parseInt(split[1]));
        }

        System.out.println(positionWrapper);
    }
}
