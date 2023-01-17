import level_4.SumOfIntervals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SumOfIntervalsTest {

    private SumOfIntervals sumOfIntervals;

    @BeforeEach
    void prepare() {
        sumOfIntervals = new SumOfIntervals();
    }

    @ParameterizedTest
    @MethodSource("getDataForSumIntervalsTest")
    void getSumIntervalsTest(int[][] intervals, int expected) {
        Assertions.assertThat(sumOfIntervals.getSumOfIntervals(intervals)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getDataForSortMethod")
    void sortArrayTest(int[][] given, List<int[]> expected) {

        assertTrue(Arrays.deepEquals(expected.toArray(int[][]::new), sumOfIntervals.sortIntervalArray(given).toArray(int[][]::new)));
    }

    private static Stream<Arguments> getDataForSortMethod() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}},
                        Arrays.asList(new int[]{-40, -35}, new int[]{-1, 2}, new int[]{2, 5}, new int[]{6, 8})),
                Arguments.of(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}},
                        Arrays.asList(new int[]{-5400, -5338}, new int[]{-7, 8}, new int[]{-2, 10}, new int[]{5, 15}, new int[]{2000, 3150})
                ));
    }

    private static Stream<Arguments> getDataForSumIntervalsTest() {
        return Stream.of(
                Arguments.of(new int[][]{{4, 4}, {6, 6}, {8, 8}}, 0),
                Arguments.of(new int[][]{{2, 5}}, 3),
                Arguments.of(new int[][]{{2, 5}, {6, 8}}, 5),
                Arguments.of(new int[][]{{-1, 2}, {1, 5}}, 6),
                Arguments.of(new int[][]{{-1, 3}, {1, 2}}, 4),
                Arguments.of(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}, 13),
                Arguments.of(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}, 1234),
                Arguments.of(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26}}, 158)
        );
    }
}
