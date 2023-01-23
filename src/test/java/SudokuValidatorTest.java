import level_4.SudokuValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

public class SudokuValidatorTest {

    private SudokuValidator sudokuValidator;

    @BeforeEach
    void prepare() {
        sudokuValidator = new SudokuValidator();
    }

    @ParameterizedTest
    @MethodSource("getDataForCheckSudokuMethod")
    void testCheckSudokuMethod(int[][] sudoku) {
        Assertions.assertThat(sudokuValidator.check(sudoku)).isTrue();

    }

    static Stream<Arguments> getDataForCheckSudokuMethod() {

        return Stream.of(Arguments.arguments(
                new Object[]{new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }
                }
        ));
    }

    @ParameterizedTest
    @MethodSource("getDataForGetRangeMethod")
    void checkGetRangeMethod(int[][] sudoku, int rangeNumber, int[] expectedArr) {
        Assertions.assertThat(sudokuValidator.getSudokuRange(sudoku, rangeNumber)).isEqualTo(expectedArr);
    }

    static Stream<Arguments> getDataForGetRangeMethod() {

        return Stream.of(Arguments.arguments(
                new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }, 2, new int[]{4, 2, 8, 9, 6, 3, 1, 7, 5}));
    }

    @ParameterizedTest
    @MethodSource("getDataForRowOrRangeTestCaseTrue")
    void checkSudokuRowOrRangeCaseTrue(int[] sudokuRow) {
        Assertions.assertThat(sudokuValidator.checkSudokuRowOrRange(sudokuRow)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("getDataForRowOrRangeTestCaseFalse")
    void checkSudokuRowCaseFalse(int[] sudokuRow) {
        Assertions.assertThat(sudokuValidator.checkSudokuRowOrRange(sudokuRow)).isFalse();
    }


    static Stream<Arguments> getDataForRowOrRangeTestCaseTrue() {
        return Stream.of(
                Arguments.of((Object) new int[]{5, 3, 4, 6, 7, 8, 9, 1, 2}),
                Arguments.of((Object) new int[]{6, 7, 2, 1, 9, 5, 3, 4, 8}),
                Arguments.of((Object) new int[]{1, 9, 8, 3, 4, 2, 5, 6, 7}),
                Arguments.of((Object) new int[]{8, 5, 9, 7, 6, 1, 4, 2, 3}),
                Arguments.of((Object) new int[]{4, 2, 6, 8, 5, 3, 7, 9, 1}),
                Arguments.of((Object) new int[]{7, 1, 3, 9, 2, 4, 8, 5, 6}),
                Arguments.of((Object) new int[]{9, 6, 1, 5, 3, 7, 2, 8, 4}),
                Arguments.of((Object) new int[]{2, 8, 7, 4, 1, 9, 6, 3, 5}),
                Arguments.of((Object) new int[]{3, 4, 5, 2, 8, 6, 1, 7, 9})
        );
    }

    static Stream<Arguments> getDataForRowOrRangeTestCaseFalse() {
        return Stream.of(
                // варианта false -> true
                Arguments.of((Object) new int[]{5, 2, 5, 2, 8, 6, 1, 7, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("getDataForTestIsValidMethod")
    void checkIsValidMethod(int[][] sudokuBlock) {
        Assertions.assertThat(sudokuValidator.isValid(sudokuBlock)).isTrue();
    }

    static Stream<Arguments> getDataForTestIsValidMethod() {
        return Stream.of(
                Arguments.of((Object) new int[][]{
                        {5, 3, 4},
                        {6, 7, 2},
                        {1, 9, 8}
                }),
                Arguments.of((Object) new int[][]{
                        {6, 7, 8},
                        {1, 9, 5},
                        {3, 4, 2}
                })

        );
    }

    @ParameterizedTest
    @MethodSource("getDataForSudokuBlocksMethod")
    void testSudokuBlocksMethod(int[][] sudoku) {
        Assertions.assertThat(sudokuValidator.checkSudokuBlocks(sudoku)).isTrue();
    }

    static Stream<Arguments> getDataForSudokuBlocksMethod() {

        return Stream.of(Arguments.arguments(
                new Object[]{new int[][]{
                        {5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}
                }
                }
        ));
    }
}
