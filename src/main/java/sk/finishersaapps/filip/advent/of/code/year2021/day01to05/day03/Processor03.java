package sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sk.finishersaapps.filip.advent.of.code.common.Processor;
import sk.finishersaapps.filip.advent.of.code.year2021.day01to05.day03.wrapper.BinaryWrapper03;

public class Processor03 extends Processor {

    @Override
    public void firstTask() throws IOException {

        List<String> lines = getLines("year21/03/input.txt");
        int charsCount = lines.get(0).length();
        BinaryWrapper03[] binaryWrapper = new BinaryWrapper03[charsCount];
        for (int i = 0; i < binaryWrapper.length; i++) {
            binaryWrapper[i] = new BinaryWrapper03();
        }
        for (String line : lines) {
            char[] charsArray = line.toCharArray();
            for (int i = 0; i < charsArray.length; i++) {
                binaryWrapper[i].addChar(charsArray[i]);
            }
        }

        int gamma = 0;
        int epsilon = 0;
        for (int i = 0; i < binaryWrapper.length; i++) {
            gamma += (binaryWrapper[i].getTheMostCommon() << (charsCount - 1 - i));
            epsilon += (binaryWrapper[i].getTheLeastCommon() << (charsCount - 1 - i));
        }

        System.out.println("Power consumption is " + (gamma * epsilon));
    }

    @Override
    public void secondTask() throws IOException {

        List<String> globalLines = getLines("year21/03/input.txt");

        filterLines(globalLines.subList(0, globalLines.size()));
    }

    private void filterLines(List<String> lines) {

        int charCount = lines.get(0).length();
        List<String> oxygenResult = null;
        List<String> oxygenLines = new ArrayList<>(lines);
        oxygenOut:
        for (int position = 0; position < charCount; position++) {
            BinaryWrapper03 binaryWrapper = getBinaryWrapper(oxygenLines, position);
            for (int i = 0; i < oxygenLines.size(); i++) {
                int valueAtPosition = getValuePosition(oxygenLines.get(i), position);
                if (valueAtPosition != binaryWrapper.getTheMostCommon()) {
                    oxygenResult = removeOrReturn(oxygenLines, i);
                    if (null != oxygenResult) {
                        break oxygenOut;
                    }
                    i--;
                }
            }
        }
        System.out.println("oxygen result = " + oxygenResult);

        List<String> co2Lines = new ArrayList<>(lines);
        List<String> co2Result = null;
        co2Out:
        for (int position = 0; position < charCount; position++) {
            BinaryWrapper03 binaryWrapper = getBinaryWrapper(co2Lines, position);
            for (int i = 0; i < co2Lines.size(); i++) {
                int valueAtPosition = getValuePosition(co2Lines.get(i), position);
                if (valueAtPosition != binaryWrapper.getTheLeastCommonWithZero()) {
                    co2Result = removeOrReturn(co2Lines, i);
                    if (null != co2Result) {
                        break co2Out;
                    }
                    i--;
                }
            }
        }

        System.out.println("co2 result = " + co2Result);
        int oxygenNumber = 0;
        int co2Number = 0;
        for (int i = 0; i < charCount; i++) {
            oxygenNumber += getValuePosition(oxygenResult.get(0), i) << (charCount - 1 - i);
            co2Number += getValuePosition(co2Result.get(0), i) << (charCount - 1 - i);
        }

        System.out.printf("oxygenNumber = %d, co2Number = %d, multiplication = %d%n", oxygenNumber, co2Number,
                oxygenNumber * co2Number);
    }

    private int getValuePosition(String line, int position) {

        if (line.charAt(position) == '0') {
            return 0;
        } else {
            return 1;
        }
    }

    private BinaryWrapper03 getBinaryWrapper(List<String> lines, int position) {

        BinaryWrapper03 binaryWrapper = new BinaryWrapper03();
        for (String line : lines) {
            binaryWrapper.addChar(line.charAt(position));
        }
        return binaryWrapper;
    }

    private List<String> removeOrReturn(List<String> values, int position) {

        if (values.size() == 1) {
            return values;
        }
        values.remove(position);
        if (values.size() == 1) {
            return values;
        }
        return null;
    }
}
