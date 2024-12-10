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
        solveHelper(board, 0, 0);
    }

    public static boolean solveHelper(char[][] board, int row, int col) {
        // Find the next empty cell
        while ((row < board.length) && (board[row][col] != '.')) {
            col++;

            if (col == board[row].length) {
                row++;
                col = 0;
            }
        }

        // If there are no empty cells left, board is solved
        if (row == board.length) {
            return true;
        }

        // Attempt to fill the current cell and solve recursively
        for (int num = 1; num <= 9; num++) {
            char value = String.valueOf(num).charAt(0);

            if (isValid(board, row, col, value)) {
                board[row][col] = value;

                // Check if that value leads to a solution
                int newRow = row;
                int newCol = col + 1;

                if (newCol == board[row].length) {
                    newRow = row + 1;
                    newCol = 0;
                }

                if (solveHelper(board, newRow, newCol)) {
                    return true;
                } else {
                    // Remove invalid value
                    board[row][col] = '.';
                }
            }
        }

        // If there is no valid solution, return false
        return false;
    }

    public static boolean isValid(char[][] board, int row, int col, char value) {
        // Check if the value is already in the row
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] == value) {
                return false;
            }
        }

        // Check if the value is already in the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // Check if the value is already in the box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        // If all checks pass, return true
        return true;
    }
}
