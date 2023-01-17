package level_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumOfIntervals {

    public int getSumOfIntervals(int[][] intervals) {
        List<int[]> inputList = sortIntervalArray(intervals);
        List<int[]> result = new ArrayList<>();
        while (inputList.size() != 1 &&
                IntStream.range(0, inputList.size() - 1)
                        .anyMatch(i -> !isFirstNotIncludeSecond(inputList.get(i), inputList.get(i + 1)))) {

            int[] first = inputList.get(0);
            int[] second = inputList.get(1);
            if (isFirstNotIncludeSecond(first, second)) {
                result.add(inputList.remove(0));
            } else if (isFirstIncludesSecond(first, second)) {
                inputList.remove(second);
            } else if (isFirstExpandedBySecondRightBorder(first, second)) {
                inputList.remove(first);
                inputList.remove(second);
                inputList.add(0, new int[]{first[0], second[1]});
            }
        }
        result.addAll(inputList);
        return result.stream().mapToInt(arr -> arr[1] - arr[0]).sum();
    }

    public List<int[]> sortIntervalArray(int[][] intervals) {
        return Arrays.stream(intervals).sorted(Comparator.comparingInt(arr -> arr[0])).collect(Collectors.toList());
    }

    private boolean isFirstNotIncludeSecond(int[] first, int[] second) {
        return first[1] < second[0];
    }

    private boolean isFirstIncludesSecond(int[] first, int[] second) {
        return first[0] <= second[0] && first[1] > second[0] && first[1] >= second[1];
    }

    private boolean isFirstExpandedBySecondRightBorder(int[] first, int[] second) {
        return first[1] >= second[0] && first[1] <= second[1];
    }

}
