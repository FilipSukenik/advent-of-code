package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

class Round {

    protected Hand opponent;

    protected Hand me;

    private static final int DRAW = 3;
    private static final int WIN = 6;

    public Round() {
    }

    Round(String line) {
        String[] input = line.split(" ");
        opponent = Hand.getByKeys(input[0]);
        me = Hand.getByKeys(input[1]);
    }

    public int resolve() {
        int myHandValue = me.getValue();
        if (me == opponent) {
            return myHandValue + DRAW;
        }
        if (me == Hand.PAPER) {
            if (opponent == Hand.SCISSORS) {
                return myHandValue;
            } else {
                return myHandValue + WIN;
            }
        }

        if (me == Hand.SCISSORS) {
            if (opponent == Hand.PAPER) {
                return myHandValue + WIN;
            } else {
                return myHandValue;
            }
        }

        if (me == Hand.ROCK) {
            if (opponent == Hand.SCISSORS) {
                return myHandValue + WIN;
            } else {
                return myHandValue;
            }
        }
        return 0;
    }
}
