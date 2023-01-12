import level_6.TenMinutesWalk;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class TenMinutesWalkTest {

    private TenMinutesWalk tenMinutesWalk;

    @BeforeEach
    void prepare() {
        tenMinutesWalk = new TenMinutesWalk();
    }

    @ParameterizedTest
    @MethodSource("getDataForIsWalkTestCaseTrue")
    void checkIsWalkMethodCaseTrue(char[] arr) {
        Assertions.assertThat(tenMinutesWalk.isValid(arr)).isTrue();

    }

    static Stream<Arguments> getDataForIsWalkTestCaseTrue() {

        return Stream.of(
                Arguments.of(new char[] {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'})
        );
    }
    @ParameterizedTest
    @MethodSource("getDataForIsWalkTestCaseFalse")
    void checkIsWalkMethodCaseFalse(char[] arr) {
        Assertions.assertThat(tenMinutesWalk.isValid(arr)).isFalse();

    }

    static Stream<Arguments> getDataForIsWalkTestCaseFalse() {

        return Stream.of(
                Arguments.of(new char[] {'n','n','n','s','n','s','n','s','n','s'}),
                Arguments.of(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'})
        );
    }

}
