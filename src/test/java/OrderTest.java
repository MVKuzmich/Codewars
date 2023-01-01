import level_6.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {

    private Order order;

    @BeforeEach
    void prepare() {
        order = new Order();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "is2 Thi1s T4est 3a, Thi1s is2 3a T4est",
            "4of Fo1r pe6ople g3ood th5e the2, Fo1r the2 g3ood 4of th5e pe6ople",
            "'', ''"
    })
    void putInOrderTest(String text, String expected) {
        Assertions.assertThat(order.putInOrder(text)).isEqualTo(expected);

    }
}
