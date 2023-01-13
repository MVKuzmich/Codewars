package level_5;

import java.util.HashMap;

public class Scramblies {

    public boolean scramble(String input, String result) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            map.computeIfPresent(ch, (k, v) -> v + 1);
            map.putIfAbsent(ch, 1);
        }
        for (char ch : result.toCharArray()) {
            Integer count = map.getOrDefault(ch, 0);
            if (count == 0) {
                return false;
            }
            map.put(ch, --count);
        }
        return true;
    }
}

