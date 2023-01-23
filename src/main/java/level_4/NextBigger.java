package level_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NextBigger {

    public long nextBiggerNumber(long n) {
        List<Integer> digits = Arrays.stream(String.valueOf(n).split("")).map(Integer::parseInt).collect(Collectors.toList());
        if (digits.size() == 1) {
            return -1;
        } else {
            for(int i = digits.size() - 1; i > 0; i--) {
                if(digits.get(i - 1) < digits.get(i)) {
                    List<Integer> head = digits.subList(0, i - 1);
                    List<Integer> tail = digits.subList(i - 1, digits.size());
                    List<Integer> rotateTail = rotateDigits(tail);
                    head.addAll(rotateTail);
                    return Long.parseLong(head.stream().map(String::valueOf).collect(Collectors.joining()));
                }
            }
        }
        return -1;
    }

    public List<Integer> rotateDigits(List<Integer> digits) {
        List<Integer> rest = new ArrayList<>();
        int first = getNearerGreaterAfterFirst(digits);
        int index = digits.indexOf(first);
        IntStream.range(0, digits.size()).filter(i -> i != index).forEach(i -> rest.add(digits.get(i)));
        rest.sort(Comparator.naturalOrder());
        rest.add(0, first);
        return rest;
    }


    public int getNearerGreaterAfterFirst(List<Integer> digits) {
        return digits.stream().filter(number -> number > digits.get(0)).mapToInt(Integer::intValue).min().getAsInt();
    }

}

