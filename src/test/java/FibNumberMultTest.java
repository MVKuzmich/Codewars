import level_5.FibNumberMult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class FibNumberMultTest {

    private FibNumberMult fibNumberMult;

    @BeforeEach
    void prepare() {
        fibNumberMult = new FibNumberMult();
    }

    @ParameterizedTest
    @MethodSource("getDataForGetFibArrMethod")
    void getFibArr(long number, List<Long> expectedArr) {

        Assertions.assertThat(fibNumberMult.getFibRangeIfNextGreater(number)).isEqualTo(expectedArr);
    }

    static Stream<Arguments> getDataForGetFibArrMethod() {
        return Stream.of(
                Arguments.of(800, List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L, 610L, 987L))
        );
    }
    @ParameterizedTest
    @MethodSource("getDataForGetMultiplyMethod")
    void getMultiply(long number, long[] expected) {

        Assertions.assertThat(fibNumberMult.productFib(number)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForGetMultiplyMethod() {
        return Stream.of(
                Arguments.of(800, new long[]{34, 55, 0}),
                Arguments.of(714, new long[]{21, 34, 1})

        );
    }
}
