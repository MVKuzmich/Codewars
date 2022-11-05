package level_6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks6 {

    //    "1000.00!=\n125 Market !=:125.45\n126 Hardware =34.95\n127 Video! 7.45\n128 Book :14.32\n129 Gasoline ::16.10";
    public String balance(String book) {
        String bookAfterDeleting = book.replaceAll("[^A-z.\s0-9\n]", "");
        String[] strings = bookAfterDeleting.split("\n");
        String result = "";
        double balance = Double.parseDouble(strings[0]);
        double totalExpense = 0;
        for (int i = 0; i < strings.length; i++) {
            if (i == 0) {
                result = result.concat(String.format("Original Balance: %.2f", balance).replace(",", "."));
            } else if (strings[i].isBlank()) {
                continue;
            } else {
                List<String> items = Arrays.stream(strings[i].split("\s+")).map(String::trim).filter(item -> !item.isBlank()).toList();
                balance -= Double.parseDouble(items.get(2));
                totalExpense += Double.parseDouble(items.get(2));
                result = result.concat("\\r\\n" + strings[i].concat("\s").concat(String.format("Balance %.2f", balance).replace(",", ".")));
            }
        }

        // your code
        return result
                .concat(String.format("\\r\\nTotal expense  %.2f", totalExpense).replace(",", "."))
                .concat(String.format("\\r\\nAverage expense  %.2f", totalExpense / (strings.length - 1)).replace(",", "."));
    }

    /*
    It should remove all values from list a, which are present in list b keeping their order.
    Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
    If a value is present in b, all of its occurrences must be removed from the other:
     */

    public int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        int[] result = new int[a.length];
        int resultIndex = 0;
        for (int i : a) {
            if (IntStream.range(0, b.length).noneMatch(num -> b[num] == i)) {
                result[resultIndex++] = i;
            }
        }
        return Arrays.copyOfRange(result, 0, resultIndex);
    }

    /*
    If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
     */
    public int solution(int number) {
        return (number > 0)
                ? IntStream.range(1, number).filter(num -> num % 3 == 0 || num % 5 == 0).sum()
                : 0;

    }

    /*
    Write a simple parser that will parse and run Deadfish.
    Deadfish has 4 commands, each 1 character long:
    i increments the value (initially 0)
    d decrements the value
    s squares the value
    o outputs the value into the return array
    Invalid characters should be ignored.
    Deadfish.parse("iiisdoso") =- new int[] {8, 64};
    */
    public int[] parse(String data) {
        int start = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.length(); i++) {
            switch (String.valueOf(data.charAt(i))) {
                case "i":
                    start++;
                    break;
                case "d":
                    start--;
                    break;
                case "s":
                    start *= start;
                    break;
                case "o":
                    result.add(start);
                    break;
                default:
                    continue;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
        // Implement me! :)
    }

    /*
    Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that
 occur more than once in the input string. The input string can be assumed to contain only alphabets
  (both uppercase and lowercase) and numeric digits.
     */
    public int duplicateCount(String text) {
        // Write your code here
        int counter = 0;
        List<String> distinct = Arrays.stream(text.toLowerCase().split("")).distinct().toList();
        if (distinct.size() == text.length()) {
            return 0;
        } else {
            for (String item : distinct) {
                if (Arrays.stream(text.toLowerCase().split("")).filter(ch -> ch.equals(item)).toList().size() > 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /*
    Complete the method/function so that it converts dash/underscore delimited words into camel casing.
    The first word within the output should be capitalized only if the original word was capitalized
     (known as Upper Camel Case, also often referred to as Pascal case).
    Examples
    "the-stealth-warrior" gets converted to "theStealthWarrior"
    "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
     */

    public String toCamelCase(String s) {
        String[] items = s.split("[_-]");

        return items[0].concat(IntStream.range(1, items.length)
                .mapToObj(i -> {
                    String[] letters = items[i].split("");
                    if (Character.isLowerCase(letters[0].toCharArray()[0])) {
                        letters[0] = String.valueOf(Character.toUpperCase(letters[0].toCharArray()[0]));
                    }
                    return String.join("", letters);
                })
                .collect(Collectors.joining("")));
    }
}
