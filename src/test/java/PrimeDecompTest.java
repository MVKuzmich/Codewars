import level_5.PrimeDecomp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class PrimeDecompTest {

    private PrimeDecomp primeDecomp;

    @BeforeEach
    void prepare() {
        primeDecomp = new PrimeDecomp();
    }

    @ParameterizedTest
    @CsvSource(value = {"7775460, (2**2)(3**3)(5)(7)(11**2)(17)", "7919, (7919)",
            "50561781, (3)(2789)(6043)"})
    void checkDecompMethod(int given, String expected) {
        Assertions.assertThat(primeDecomp.factors(given)).isEqualTo(expected);
    }

//    @ParameterizedTest
//    @MethodSource("getDataForPrimeMethod")
//    void checkGetPrimeMethod(int prevPrime, int limit, int expected) {
//        Assertions.assertThat(primeDecomp.getNextPrimeNumberUntil(prevPrime, limit)).isEqualTo(expected);
//    }

    static Stream<Arguments> getDataForPrimeMethod() {
        return Stream.of(
                Arguments.of(5, 45, 7)
        );
    }
}
