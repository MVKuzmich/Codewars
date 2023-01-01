package level_6;


/*
Your task is to sort a given string. Each word in the string will contain a single number.
This number is the position the word should have in the result.
Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
If the input string is empty, return an empty string.
The words in the input String will only contain valid consecutive numbers.
Examples: "is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
 */


import java.util.*;
import java.util.stream.IntStream;

public class Order {
    public String putInOrder(String words) {
        if (words.isEmpty()) {
            return "";
        } else {
            Map<Integer, String> store = new TreeMap<>();
            String[] wordArray = words.split(" ");
            Arrays.stream(wordArray).forEach(word -> {
                int number = IntStream.range(0, word.length())
                        .filter(index -> Character.isDigit(word.charAt(index)))
                        .map(word::charAt)
                        .mapToObj(String::valueOf)
                        .mapToInt(Integer::parseInt)
                        .findFirst()
                        .getAsInt();
                store.put(number, word);
            });
            return String.join(" ", store.values());
        }
    }
}
