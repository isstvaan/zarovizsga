package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;

public class DigitsCounter {
    public int getCountOfDigits(String str) {
        if (str == null) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        for (Character item : str.toCharArray()) {
            if (Character.isDigit(item)) {
                set.add(item);
            }
        }
        return set.size();
    }
}
