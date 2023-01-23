import level_4.NextBigger;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class NextBiggerTest {

    private NextBigger nextBigger;

    @BeforeEach
    void prepare() {
        nextBigger = new NextBigger();
    }

    @ParameterizedTest
    @CsvSource(value = {"9, -1", "20, -1", "12, 21", "22, -1", "100, -1", "111, -1", "55555555, -1", "6543, -1", "3621, 6123", "3777, 7377", "1234, 1243"})
    void nextBiggerTest(long given, long expected) {
        Assertions.assertThat(nextBigger.nextBiggerNumber(given)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getDataForGetNearerGreaterTest")
    void getNearerGreaterDigitsTest(List<Integer> digits, int expected) {
        Assertions.assertThat(nextBigger.getNearerGreaterAfterFirst(digits)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForGetNearerGreaterTest() {
        return Stream.of(
                Arguments.of(List.of(4, 6, 2, 1), 1),
                Arguments.of(List.of(3, 7, 7, 7), 1),
                Arguments.of(List.of(4, 8, 4, 5), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getDataForRotateDigitsTest")
    void TestRotateDigitsMethod(List<Integer> digits, List<Integer> expected) {
        Assertions.assertThat(nextBigger.rotateDigits(digits)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForRotateDigitsTest() {
        return Stream.of(
                Arguments.of(new ArrayList<>(List.of(4, 6, 2, 1)), List.of(6, 1, 2, 4)),
                Arguments.of(new ArrayList<>(List.of(3, 7, 7, 7)), List.of(7, 3, 7, 7)),
                Arguments.of(new ArrayList<>(List.of(4, 8, 4, 5, 7, 1)), List.of(5, 1, 4, 4, 7, 8))
        );
    }


}

