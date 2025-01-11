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
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 1;

        System.out.println(solveNQueens(n));
    }

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        nQueensHelper(n, 0, new ArrayList<>(), -2, new ArrayList<>(), result);

        return result;
    }

    private static void nQueensHelper(int n, int row, List<Integer> columnSet, int lastColumn,
                                      List<String> current, List<List<String>> result) {
        // Base case: If all rows filled, valid solution is found
        if (row == n) {
            result.add(new ArrayList<>(current));

            return;
        }

        // Recursive case: Try to place a queen in each valid spot in the next row
        for (int j = 0; j < n; j++) {
            boolean diagonal = false;

            // Check diagonals
            for (int i = 0; i < row - 1; i++) {
                if (row - i == Math.abs(columnSet.get(i) - j)) {
                    diagonal = true;
                    break;
                }
            }

            if (diagonal) {
                continue;
            }

            if (!columnSet.contains(j) && Math.abs(lastColumn - j) >= 2) {
                // Place queen and continue recursively
                StringBuilder sb = new StringBuilder();

                for (int i = 0; i < n; i++) {
                    if (i == j) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }

                current.add(sb.toString());

                ArrayList<Integer> nextColumnSet = new ArrayList<>(columnSet);
                nextColumnSet.add(j);

                nQueensHelper(n, row + 1, nextColumnSet, j, current, result);

                // Reset row and try remaining columns
                current.remove(current.size() - 1);
            }
        }
    }
}
