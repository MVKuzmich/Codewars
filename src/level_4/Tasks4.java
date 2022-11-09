package level_4;

import javax.swing.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Tasks4 {

    /*
    For seconds = 62, your function should return
    "1 minute and 2 seconds"
    For seconds = 3662, your function should return
    "1 hour, 1 minute and 2 seconds"
     */
    public String formatDuration(int seconds) {
        String result = "";
        if (seconds == 0) {
            return "now";
        } else {
            int oneMinute = 60;
            int oneHour = oneMinute * 60;
            int oneDay = oneHour * 24;
            int oneYear = oneDay * 365;

            Map<String, Integer> time = new LinkedHashMap<>();
            time.put("year", seconds / oneYear);
            time.put("day", seconds % oneYear / oneDay);
            time.put("hour", seconds % oneDay / oneHour);
            time.put("minute", seconds % oneHour / oneMinute);
            time.put("second", seconds % oneMinute);
            List<String> timeParts = new ArrayList<>();

            for (Map.Entry<String, Integer> entry : time.entrySet()) {
                if (time.get(entry.getKey()) > 0) {
                    timeParts.add(String.valueOf(entry.getValue()).concat(" ").concat((entry.getValue() > 1) ? entry.getKey().concat("s") : entry.getKey()));
                }
            }
            if (timeParts.size() == 1) {
                result = timeParts.get(0);
            } else if (timeParts.size() == 2) {
                result = String.join(" and ", timeParts);
            } else {
                String lastPart = " and " + timeParts.remove(timeParts.size() - 1);
                result = String.join(", ", timeParts).concat(lastPart);
            }
        }
        return result;
    }

    /*
    Given the string representations of two integers, return the string representation of the sum of those integers.
    For example:
    sumStrings('1','2') // => '3'
    A string representation of an integer will contain no characters besides the ten numerals "0" to "9".
    I have removed the use of BigInteger and BigDecimal in java
     */
    public String sumStrings(String a, String b) {
        List<Integer> result = new ArrayList<>();
        a = formatIfZeroExistOrEmpty(a);
        b = formatIfZeroExistOrEmpty(b);
        List<Integer> listA = Arrays.stream(a.split("")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b.split("")).map(Integer::parseInt).collect(Collectors.toList());
        if (listA.size() > listB.size()) {
            IntStream.range(0, listA.size() - listB.size()).forEach(item -> listB.add(0, 0));
        } else if (listA.size() < listB.size()) {
            IntStream.range(0, listB.size() - listA.size()).forEach(item -> listA.add(0, 0));
        }
        for (int i = listA.size() - 1; i >= 0; i--) {
            int sum = listA.get(i) + listB.get(i);
            result.add(sum);
        }
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) >= 10) {
                result.set(i, result.get(i) - 10);
                result.set(i + 1, result.get(i + 1) + 1);
            }
        }
        Collections.reverse(result);
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public String formatIfZeroExistOrEmpty(String str) {
        int index = 0;
        if (str.isBlank()) {
            return "0";
        } else if (String.valueOf(str.charAt(0)).equals("0")) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0') {
                    index = i;
                    break;
                }
            }
            return str.substring(index);
        }
        return str;
    }
}

