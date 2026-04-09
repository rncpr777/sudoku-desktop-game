package sudoku.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;

public class DifficultyEnumTest {

    // Creates a fully filled board (all fields set to 1)
    private SudokuBoard createFilledBoard() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                board.setField(row, col, 1);
            }
        }
        return board;
    }

    private int countEmptyFields(SudokuBoard board) {
        int count = 0;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board.getField(row, col).getValue() == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    public void testEasyClearsThirtyFields() {
        SudokuBoard board = createFilledBoard();
        DifficultyEnum.EASY.clearSudokuFieldsFromSudokuBoardBasedOnDifficulty(board);
        assertEquals(30, countEmptyFields(board));
    }

    @Test
    public void testMediumClearsFiftyFields() {
        SudokuBoard board = createFilledBoard();
        DifficultyEnum.MEDIUM.clearSudokuFieldsFromSudokuBoardBasedOnDifficulty(board);
        assertEquals(50, countEmptyFields(board));
    }

    @Test
    public void testHardClearsSeventyFields() {
        SudokuBoard board = createFilledBoard();
        DifficultyEnum.HARD.clearSudokuFieldsFromSudokuBoardBasedOnDifficulty(board);
        assertEquals(70, countEmptyFields(board));
    }
}