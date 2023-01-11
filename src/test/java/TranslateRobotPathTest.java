import level_6.TranslateRobotPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.stream.Stream;

public class TranslateRobotPathTest {

    private TranslateRobotPath translateRobotPath;

    @BeforeEach
    void prepare() {
        translateRobotPath = new TranslateRobotPath();
    }

    @ParameterizedTest
    @MethodSource("getDataForCheckRemoveCharMethod")
    void checkWalkMethod(String str, String expected) {
        Assertions.assertThat(translateRobotPath.walk(str)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForCheckRemoveCharMethod() {
        return Stream.of(
                Arguments.of(">", "Take 1 step right"),
                Arguments.of(">>", "Take 2 steps right"),
                Arguments.of(">>>", "Take 3 steps right"),
                Arguments.of("><", "Take 1 step right\nTake 1 step left"),
                Arguments.of(">><", "Take 2 steps right\nTake 1 step left"),
                Arguments.of("><<", "Take 1 step right\nTake 2 steps left"),
                Arguments.of("<^>>><<<><", "Take 1 step left\n" +
                        "Take 1 step up\n" +
                        "Take 3 steps right\n" +
                        "Take 3 steps left\n" +
                        "Take 1 step right\n" +
                        "Take 1 step left")


        );
    }
}
