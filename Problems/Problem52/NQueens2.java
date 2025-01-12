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
        // Keep track of columns used and diagonals used, filling row-wise
        boolean[] columnsUsed = new boolean[n];
        boolean[] diagonal = new boolean[2*n - 1];
        boolean[] antiDiagonal = new boolean[2*n - 1];

        return nQueensDFS(columnsUsed, diagonal, antiDiagonal, 0);
    }

    private static int nQueensDFS(boolean[] columnsUsed, boolean[] diagonal, boolean[] antiDiagonal, int row) {
        int n = columnsUsed.length, count = 0;

        // If all rows are filled, add a solution
        if (row == n) {
            return 1;
        }

        // Fill subsequent rows using a DFS
        for (int column = 0; column < n; column++) {
            // Check that the current column and both the upper left and upper right diagonals are not used
            if (!columnsUsed[column] && !diagonal[row + column] && !antiDiagonal[row - column + n - 1]) {
                columnsUsed[column] = diagonal[row + column] = antiDiagonal[row - column + n - 1] = true;
                count += nQueensDFS(columnsUsed, diagonal, antiDiagonal, row + 1);
                columnsUsed[column] = diagonal[row + column] = antiDiagonal[row - column + n - 1] = false;
            }
        }

        return count;
    }
}
