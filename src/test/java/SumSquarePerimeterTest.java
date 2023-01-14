import level_5.SumSquarePerimeter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SumSquarePerimeterTest {

    private SumSquarePerimeter sumSquarePerimeter;

    @BeforeEach

    void prepare() {
        sumSquarePerimeter = new SumSquarePerimeter();
    }

    @ParameterizedTest
    @MethodSource("getDataForTestMethod")
    void checkPerimeterMethod(BigInteger n, BigInteger expected) {
        Assertions.assertThat(sumSquarePerimeter.perimeter(n)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForTestMethod() {
        return Stream.of(
                Arguments.of(BigInteger.valueOf(5L), BigInteger.valueOf(80L)),
                Arguments.of(BigInteger.valueOf(7L), BigInteger.valueOf(216L))
        );
    }
}
