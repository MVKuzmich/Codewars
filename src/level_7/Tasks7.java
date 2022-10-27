package level_7;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Tasks7 {
    /* An isogram is a word that has no repeating letters, consecutive or non-consecutive.
    Implement a function that determines whether a string that contains only letters is an isogram.
    Assume the empty string is an isogram. Ignore letter case.
    Example: (Input --> Output) -> "Dermatoglyphics" --> true "aba" --> false "moOse" --> false (ignore letter case)
    */
    public boolean isIsogram(String str) {
        Set<Character> set = new HashSet<>();
        if (!str.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                if (!set.add(str.toLowerCase().charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
