package sk.finishersaapps.filip.advent.of.code.year2021.day11to15.day14;

import java.util.ArrayList;
import java.util.List;

public class Rule14 {

    private String source;

    private String addition;

    private List<String> pairs;

    public Rule14(String input) {

        String[] splitInput = input.split(" -> ");
        source = splitInput[0];
        addition = splitInput[1];
        pairs = new ArrayList<>();

        pairs.add(source.charAt(0) + addition);
        pairs.add(addition + source.charAt(1));
    }

    @Override
    public String toString() {

        return "Rule{" + source + "->" + addition + "}";
    }

    public String getAddition() {

        return addition;
    }

    public String getSource() {

        return source;
    }

    public List<String> toPairs() {

        return pairs;
    }
}
