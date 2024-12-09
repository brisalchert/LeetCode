//----------------------------------------------------------------------------------------------------------------------
//  36. Valid Sudoku
//
//  Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following
//  rules:
//
//  1. Each row must contain the digits 1-9 without repetition.
//  2. Each column must contain the digits 1-9 without repetition.
//  3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
//
//  Note:
//  - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
//  - Only the filled cells need to be validated according to the mentioned rules.
//----------------------------------------------------------------------------------------------------------------------

package Problem36;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        // Iterate through each cell in the board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char value = board[row][col];
                int box = ((row / 3) * 3) + (col / 3);

                // Ignore empty cells
                if (value != '.') {
                    // Attempt to add the value for the given row, column, and box
                    if (!seen.add(value + " row " + row) ||
                        !seen.add(value + " col " + col) ||
                        !seen.add(value + " box " + box)) {
                        return false;
                    }
                }
            }
        }

        // If all checks pass, return true
        return true;
    }
}
