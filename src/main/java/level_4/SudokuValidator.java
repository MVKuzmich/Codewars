package level_4;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuValidator {

    public boolean check(int[][] sudoku) {
        //do your magic
        return IntStream.range(0, sudoku.length).allMatch(i -> checkSudokuRowOrRange(sudoku[i]))
                && IntStream.range(0, sudoku.length).allMatch(i -> checkSudokuRowOrRange(getSudokuRange(sudoku, i)))
                && checkSudokuBlocks(sudoku);
    }

    public boolean checkSudokuRowOrRange(int[] sudokuRow) {
        Set<Integer> set = Arrays.stream(sudokuRow).boxed().collect(Collectors.toSet());
        return set.size() == 9
                && set.stream().mapToInt(Integer::intValue).sum() == 45
                && Arrays.stream(sudokuRow).max().getAsInt() == 9
                && Arrays.stream(sudokuRow).min().getAsInt() == 1;
    }

    public int[] getSudokuRange(int[][] sudoku, int rangeNumber) {
        int[] range = new int[sudoku.length];
        for (int i = 0; i < sudoku.length; i++) {
            range[i] = sudoku[i][rangeNumber];
        }
        return range;
    }

    public boolean checkSudokuBlocks(int[][] sudoku) {
        int sudokuRange = 0;
        while (sudokuRange < sudoku.length) {
            int sudokuRow = 0;
            int rangeStart = sudokuRange;
            int[][] block = new int[3][3];
            int rowIndexBlock = 0;
            for (int i = sudokuRow; i < sudoku.length; i++) {
                int rangeIndexBlock = 0;
                for (int j = rangeStart; j < rangeStart + 3; j++) {
                    block[rowIndexBlock][rangeIndexBlock++] = sudoku[i][j];
                }
                rowIndexBlock++;
                if ((i + 1) % 3 == 0 && !isValid(block)) {
                    return false;
                } else if((i + 1) % 3 == 0 && isValid(block)) {
                    rangeStart = sudokuRange;
                    block = new int[3][3];
                    rowIndexBlock = 0;
                }
            }
            sudokuRange += 3;
        }
        return true;
    }

    public boolean isValid(int[][] block) {
        int[] array = Arrays.stream(block).flatMapToInt(Arrays::stream).toArray();
        return checkSudokuRowOrRange(array);
    }

}
