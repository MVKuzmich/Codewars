import level_5.Scramblies;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class ScrambliesTest {

    private Scramblies scramblies;

    @BeforeEach
    void prepare() {
        scramblies = new Scramblies();
    }

    @ParameterizedTest
    @CsvSource(value= {"rkqodlw, world"})
    void checkScrambleMethodCaseTrue(String input, String result) {
        Assertions.assertThat(scramblies.scramble(input, result)).isTrue();
    }
    @ParameterizedTest
    @CsvSource(value = {"rkqodlw, world1", "scriptjavx, javascript"})
    void checkScrambleMethodCaseFalse(String input, String result) {
        Assertions.assertThat(scramblies.scramble(input, result)).isFalse();
    }
}
