import level_6.UniqueNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class UniqueNumberTest {

    private UniqueNumber uniqueNumber;

    @BeforeEach
    void prepare() {
        uniqueNumber = new UniqueNumber();
    }

    @ParameterizedTest
    @MethodSource("getDataForUniqueNumberTest")
    void checkUniqueNumberMethod(double[] arr, double expected) {
        Assertions.assertThat(uniqueNumber.findUniq(arr)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForUniqueNumberTest() {
        return Stream.of(
                Arguments.of(new double[]{ 1, 1, 1, 2, 1, 1 }, 2),
                Arguments.of(new double[]{ 0, 0, 0.55, 0, 0 }, 0.55),
                Arguments.of(new double[]{ 0, 0, 0, 0, 8}, 8)

                );
    }
}

