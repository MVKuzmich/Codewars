import level_5.WeightSort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeightSortTest {

    private WeightSort weightSort;

    @BeforeEach
    void prepare() {
        weightSort = new WeightSort();
    }

    @ParameterizedTest
    @CsvSource(value = {"103 123 4444 99 2000, 2000 103 123 4444 99",
            "2000 10003 1234000 44444444 9999 11 11 22 123, 11 11 2000 10003 22 123 1234000 44444444 9999",
    "59544965313, 59544965313"})
    void checkOrderWeightMethod(String given, String expected) {
        Assertions.assertThat(weightSort.orderWeight(given)).isEqualTo(expected);
    }

}
