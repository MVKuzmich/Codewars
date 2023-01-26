import level_5.PigLatin;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PigLatinTest {

    private PigLatin pigLatin;

    @BeforeEach
    void prepare() {
        pigLatin = new PigLatin();
    }

    @ParameterizedTest
    @CsvSource(value = {"Pig latin is cool, igPay atinlay siay oolcay", "This is my string, hisTay siay ymay tringsay"})
    void checkPigItMethod(String given, String expected) {
        Assertions.assertThat(pigLatin.pigIt(given)).isEqualTo(expected);
    }
}
