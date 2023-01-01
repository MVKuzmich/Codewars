package level_6;

import java.util.*;
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

    /*
    You are given an array (which will have a length of at least 3, but could be very large) containing integers.
    The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
    Write a method that takes the array as an argument and returns this "outlier" N.
    Examples
    [2, 4, 0, 100, 4, 11, 2602, 36]
    Should return: 11 (the only odd number)

    [160, 3, 1719, 19, 11, 13, -21]
    Should return: 160 (the only even number)
     */
    public int find(int[] integers) {
        int result = 0;
        if (checkEven(integers)) {
            result = Arrays.stream(integers).filter(i -> i % 2 != 0).findFirst().getAsInt();
        } else {
            result = Arrays.stream(integers).filter(i -> i % 2 == 0).findFirst().getAsInt();
        }

        return result;
    }

    private boolean checkEven(int[] integers) {
        int countOdd = 0;
        int countEven = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        return countEven > countOdd;
    }

    /*
    The goal of this exercise is to convert a string to a new string where each character in the new string is "("
     if that character appears only once in the original string,
     or ")" if that character appears more than once in the original string.
      Ignore capitalization when determining if a character is a duplicate.
    Examples
    "din"      =>  "((("
    "recede"   =>  "()()()"
    "Success"  =>  ")())())"
    "(( @"     =>  "))(("
     */
    public String encode(String word) {
        String example = word.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        String[] letters = example.split("");
        for (String letter : letters) {
            map.computeIfPresent(letter, (key, value) -> value + 1);
            map.putIfAbsent(letter, 1);
        }
        String[] result = new String[letters.length];
        for (int i = 0; i < letters.length; i++) {
            result[i] = (map.get(letters[i]) == 1) ? "(" : ")";
        }
        return String.join("", result);
    }

    /*
    Your job is to write a function which increments a string, to create a new string.
    If the string already ends with a number, the number should be incremented by 1.
    If the string does not end with a number. the number 1 should be appended to the new string.
    Examples:
    foo -> foo1
    foobar23 -> foobar24
    foo0042 -> foo0043
    foo9 -> foo10
    foo099 -> foo100
    Attention: If the number has leading zeros the amount of digits should be considered.
     */
    public String incrementString(String str) {
        int startNumberIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                startNumberIndex = i;
                break;
            }
        }
        String result = "";
        if (startNumberIndex == 0) {
            return (str.isBlank()) ? "1" : str.concat("1");
        } else {
            String letterPart = str.substring(0, startNumberIndex);
            String numberPart = str.substring(startNumberIndex);
            String number = Arrays.stream(numberPart.split(""))
                    .map(Integer::parseInt)
                    .filter(num -> num > 0)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
            if ((numberPart.length() == number.length())) {
                result = letterPart.concat(String.valueOf(Integer.parseInt(number) + 1));
            } else {
                String formatPattern = "%0" + numberPart.length() + "d";
                result = letterPart.concat(String.format(formatPattern, Integer.parseInt(number) + 1));
            }
        }
        return result;
    }
    /*
    The integers 14 and 15, are contiguous (1 the difference between them, obvious) and have the same number of divisors.
14 ----> 1, 2, 7, 14 (4 divisors)
15 ----> 1, 3, 5, 15 (4 divisors)
     */

    public int countPairsInt(int diff, long nMax) {
        List<Integer[]> list = new ArrayList<>();
        int countPair = 0;
        int i = 1;
        while (i + diff < nMax) {
            int one = countDivisor(i);
            int two = countDivisor(i + diff);
            if (one == two) {
                list.add(new Integer[]{i, i + diff});
                countPair++;
            }
            i++;
        }
        // your code
        list.forEach(item -> System.out.print(Arrays.toString(item)));
        return countPair;
    }

    public int countDivisor(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}

