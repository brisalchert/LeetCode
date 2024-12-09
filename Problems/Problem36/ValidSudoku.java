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
        return false;
    }
}
