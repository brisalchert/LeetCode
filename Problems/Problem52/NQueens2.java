//----------------------------------------------------------------------------------------------------------------------
//  52. N-Queens II
//
//  The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
//  each other.
//
//  Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
//  Example 1:
//    Input: n = 4
//    Output: 2
//    Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//----------------------------------------------------------------------------------------------------------------------

package Problem52;

public class NQueens2 {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(totalNQueens(n));
    }

    public static int totalNQueens(int n) {
        int result = 0;
        boolean[] columnsUsed = new boolean[n];
        int[] columnValues = new int[n];
        int mid = (n + 1) / 2;

        // Only find solutions for the left half of the board (including
        // center): other solutions will be mirrored
        for (int j = 0; j < mid; j++) {
            columnValues[0] = j;
            columnsUsed[j] = true;
            result = nQueensDFS(n, 1, columnsUsed, columnValues, result);
            columnsUsed[j] = false;
        }

        return result;
    }

    private static int nQueensDFS(int n, int row, boolean[] columnsUsed,
                                   int[] columnValues, int result) {
        if (row == n) {
            // Add solution
            result++;

            // If the first queen is not in the center column, add the mirrored solution
            if (!(n % 2 == 1 && columnValues[0] == (n / 2))) {
                result++;
            }

            return result;
        }

        // Try to place a queen in each column for the current row
        for (int j = 0; j < n; j++) {
            if (columnsUsed[j]) {
                continue;
            }

            // Check diagonals with previous rows
            boolean diagonal = false;
            for (int r = 0; r < row; r++) {
                if (row - r == Math.abs(columnValues[r] - j)) {
                    diagonal = true;
                    break;
                }
            }

            if (diagonal) {
                continue;
            }

            columnsUsed[j] = true;
            columnValues[row] = j;
            result = nQueensDFS(n, row + 1, columnsUsed, columnValues, result);
            columnsUsed[j] = false;
        }

        return result;
    }
}
