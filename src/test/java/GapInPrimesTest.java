import level_5.GapInPrimes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class GapInPrimesTest {

    private GapInPrimes gapInPrimes;

    @BeforeEach
    void prepare() {
        gapInPrimes = new GapInPrimes();
    }

    @ParameterizedTest
    @MethodSource("getDataForFindFirstPrimes")
    void checkFindFirstPrimesMethod(int gap, long start, long end, long[] expected) {
        Assertions.assertThat(gapInPrimes.findFirstPrimesWithGap(gap, start, end)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForFindFirstPrimes() {
        return Stream.of(
                Arguments.of(2, 100, 110, new long[]{101, 103}),
                Arguments.of(4, 100, 110, new long[]{103, 107}),
                Arguments.of(6, 100, 110, null)
        );
    }

    @ParameterizedTest
    @ValueSource(longs = {3, 5, 41, 43, 17})
    void checkIsPrimeMethodCaseTrue(long given) {
        Assertions.assertThat(gapInPrimes.isPrime(given)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(longs = {30, 50, 42, 430, 172})
    void checkIsPrimeMethodCaseFalse(long given) {
        Assertions.assertThat(gapInPrimes.isPrime(given)).isFalse();
    }
}
