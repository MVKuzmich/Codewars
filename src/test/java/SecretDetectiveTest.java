import level_4.SecretDetective;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SecretDetectiveTest {

    private SecretDetective secretDetective;

    @BeforeEach
    void prepare() {
        secretDetective = new SecretDetective();
    }

    @ParameterizedTest
    @MethodSource("getDataForRecoverSecretMethod")
    void checkRecoverSecretMethod(char[][] triplets, String expected) {
        Assertions.assertThat(secretDetective.recoverSecret(triplets)).isEqualTo(expected);
    }

    static Stream<Arguments> getDataForRecoverSecretMethod() {

        return Stream.of(Arguments.arguments(
                new char[][]{
                        {'t', 'u', 'p'},
                        {'w', 'h', 'i'},
                        {'t', 's', 'u'},
                        {'a', 't', 's'},
                        {'h', 'a', 'p'},
                        {'t', 'i', 's'},
                        {'w', 'h', 's'}
                }, "whatisup"));
    }


}
