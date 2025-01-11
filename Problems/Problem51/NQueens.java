//----------------------------------------------------------------------------------------------------------------------
//  51. N-Queens
//
//  The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack
//  each other.
//
//  Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
//  Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
//  a queen and an empty space, respectively.
//
//  Example 1:
//    Input: n = 4
//    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
//----------------------------------------------------------------------------------------------------------------------

package Problem51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[] columnsUsed = new boolean[n];
        int[] columnValues = new int[n];
        int mid = (n + 1) / 2;

        // Only find solutions for the left half of the board (including
        // center): other solutions will be mirrored
        for (int j = 0; j < mid; j++) {
            columnValues[0] = j;
            columnsUsed[j] = true;
            nQueensDFS(n, 1, columnsUsed, columnValues, result);
            columnsUsed[j] = false;
        }

        return result;
    }

    private static void nQueensDFS(int n, int row, boolean[] columnsUsed,
                                   int[] columnValues, List<List<String>> result) {
        if (row == n) {
            // Add solution
            addResult(n, columnValues, result);

            return;
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
            nQueensDFS(n, row + 1, columnsUsed, columnValues, result);
            columnsUsed[j] = false;
        }
    }

    private static void addResult(int n, int[] columns, List<List<String>> result) {
        List<String> solution = new ArrayList<>();
        char[] currentRow = new char[n];
        Arrays.fill(currentRow, '.');

        for (int col : columns) {
            currentRow[col] = 'Q';
            solution.add(new String(currentRow));
            currentRow[col] = '.';
        }

        result.add(solution);

        // If n is odd and the first queen is in the middle column,
        // mirror will be identical
        if (n % 2 == 1 && columns[0] == (n / 2)) {
            return;
        }

        // Add mirrored solution to result
        List<String> mirrorSolution = new ArrayList<>();

        for (String row : solution) {
            String reverseRow = new StringBuilder(row).reverse().toString();
            mirrorSolution.add(reverseRow);
        }

        result.add(mirrorSolution);
    }
}
