package sk.finishersaapps.filip.advent.of.code.year2021.day06to10.day06;

import java.util.HashMap;

public class FishMap06 extends HashMap<Integer, Long> {

    public Long addValue(Integer key) {

        Long oldValue = get(key);
        super.put(key, oldValue + 1L);
        return oldValue;
    }

    public void dayPassed() {

        Long oldValue = get(-1);
        for (int i = size() - 2; i >= -1; i--) {
            oldValue = put(i, oldValue);
        }
        Long newborns = get(-1);
        put(8, newborns);
        put(6, get(6) + newborns);
        put(-1, 0L);
    }

    public Long countFish() {

        Long count = 0L;
        System.out.println(this);
        for (Long value : values()) {
            count += value;
        }
        return count;
    }
}
