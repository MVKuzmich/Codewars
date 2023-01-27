package level_5;

import java.util.*;
import java.util.stream.Collectors;

public class WeightSort {
    public String orderWeight(String rowNumbers) {
        return Arrays.stream(rowNumbers.split(" ")).sorted((String n1, String n2) -> {
            int w1 = Arrays.stream(n1.split("")).mapToInt(d -> Integer.parseInt(d)).sum();
            int w2 = Arrays.stream(n2.split("")).mapToInt(d -> Integer.parseInt(d)).sum();
            if (w1 < w2) {
                return -1;
            } else if (w1 == w2) {
                return n1.compareTo(n2);
            } else {
                return 1;
            }
        }).collect(Collectors.joining(" "));
    }
}
//    public String orderWeight(String rowNumbers) {
//        String[] arr = rowNumbers.trim().split("\s+");
//        if (rowNumbers.isEmpty()) {
//            return "";
//        } else if (arr.length == 1) {
//            return arr[0];
//        } else {
//            List<Long> digits = Arrays.stream(arr).map(Long::parseLong).collect(Collectors.toList());
//
//            Collections.sort(digits, new DigitComparator());
//
//            return String.join(" ", digits.stream().map(String::valueOf).collect(Collectors.toList()));
//        }
//    }
//
//        private class DigitComparator implements Comparator<Long> {
//
//            @Override
//            public int compare(Long o1, Long o2) {
//                int o1sum = Arrays.stream(String.valueOf(o1).split("")).map(Integer::parseInt).mapToInt(Integer::intValue).sum();
//                int o2sum = Arrays.stream(String.valueOf(o2).split("")).map(Integer::parseInt).mapToInt(Integer::intValue).sum();
//                if (o1sum > o2sum) {
//                    return 1;
//                } else if (o1sum < o2sum) {
//                    return -1;
//                } else {
//                    int counter = 0;
//                    String o1str = String.valueOf(o1);
//                    String o2str = String.valueOf(o2);
//                    while (o1str.length() > counter || o2str.length() > counter) {
//                        long o1digit = Long.parseLong(String.valueOf(o1str.charAt(counter)));
//                        long o2digit = Long.parseLong(String.valueOf(o2str.charAt(counter)));
//                        if (o1digit > o2digit) {
//                            return 1;
//                        } else if (o1digit < o2digit) {
//                            return -1;
//                        }
//                        counter++;
//                    }
//                    return o1str.length() - o2str.length();
//                }
//            }
//        }
//    }
