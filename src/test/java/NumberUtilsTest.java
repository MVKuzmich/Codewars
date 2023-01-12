import level_6.NumberUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberUtilsTest {

    private NumberUtils numberUtils;

    @BeforeEach
    void prepare() {
        numberUtils = new NumberUtils();
    }

    @ParameterizedTest
    @ValueSource(ints = {153, 1634})
    void isNarcissisticTestCaseTrue(int number) {
        Assertions.assertThat(numberUtils.isNarcissistic(number)).isTrue();
    }
    @ParameterizedTest
    @ValueSource(ints = {112, 1652})
    void isNarcissisticTestCaseFalse(int number) {
        Assertions.assertThat(numberUtils.isNarcissistic(number)).isFalse();
    }


}
