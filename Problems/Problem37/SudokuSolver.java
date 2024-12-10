//----------------------------------------------------------------------------------------------------------------------
//  37. Sudoku Solver
//
//  Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//  A sudoku solution must satisfy all of the following rules:
//
//  1. Each of the digits 1-9 must occur exactly once in each row.
//  2. Each of the digits 1-9 must occur exactly once in each column.
//  3. Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//
//  The '.' character indicates empty cells.
//----------------------------------------------------------------------------------------------------------------------

package Problem37;

import java.util.Arrays;

public class SudokuSolver {
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

        solveSudoku(board);

        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void solveSudoku(char[][] board) {
        // Call recursive helper function
        solveHelper(board);
    }

    public static boolean solveHelper(char[][] board) {
        // Find the next empty cell
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    // Attempt to fill the current cell and solve recursively
                    for (char value = '1'; value <= '9'; value++) {
                        if (isValid(board, row, col, value)) {
                            board[row][col] = value;

                            if (solveHelper(board)) {
                                return true;
                            }

                            // Remove invalid value
                            board[row][col] = '.';
                        }
                    }

                    // If no value returns true, current board is invalid
                    return false;
                }
            }
        }

        // If there are no more empty cells, board is solved
        return true;
    }

    public static boolean isValid(char[][] board, int row, int col, char value) {
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        // Check if the value is already in the row, box, or column
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value || board[i][col] == value ||
            board[boxRow + i / 3][boxCol + i % 3] == value) {
                return false;
            }
        }

        // If all checks pass, return true
        return true;
    }
}
