package sk.finishersaapps.filip.advent.of.code.year2022.day6to10.day6;

public class CommunicationReceiver {

    private final String message;

    public CommunicationReceiver(String message) {

        this.message = message;
    }

    public int findStartingSequence(int size) {
        for (int i = 0; i < message.length() - size; i++) {
            if (areAllUnique(message.substring(i, i + size))) {
                return i + size;
            }
        }
        return -1;
    }

    private boolean areAllUnique(String part) {
        for (int i = 0; i < part.length(); i++) {
            for (int j = i + 1; j < part.length(); j++) {
                char first = part.charAt(i);
                char second = part.charAt(j);
                if (first == second) {
                    return false;
                }
            }
        }
        return true;
    }
}
