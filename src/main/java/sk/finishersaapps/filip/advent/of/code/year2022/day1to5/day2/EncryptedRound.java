package sk.finishersaapps.filip.advent.of.code.year2022.day1to5.day2;

public class EncryptedRound extends Round {

    public EncryptedRound(String line) {
        String[] input = line.split(" ");
        opponent = Hand.getByKeys(input[0]);
        Outcome outcome = Outcome.findByKey(input[1]);
        me = outcomeToHand(outcome, opponent);
    }

    private Hand outcomeToHand(Outcome outcome, Hand opponent) {
        if (outcome == Outcome.DRAW) {
            return opponent;
        }
        if (outcome == Outcome.WIN) {
            if (opponent == Hand.ROCK) {
                return Hand.PAPER;
            }
            if (opponent == Hand.PAPER) {
                return Hand.SCISSORS;
            }
            if (opponent == Hand.SCISSORS) {
                return Hand.ROCK;
            }
        }
        if (outcome == Outcome.LOOSE) {
            if (opponent == Hand.ROCK) {
                return Hand.SCISSORS;
            }
            if (opponent == Hand.PAPER) {
                return Hand.ROCK;
            }
            if (opponent == Hand.SCISSORS) {
                return Hand.PAPER;
            }
        }
        return null;
    }
}
