//----------------------------------------------------------------------------------------------------------------------
//  62. Unique Paths
//
//  There is a robot on an m x n grid. The robot is initially located in the top-left corner (i.e., grid[0][0]).
//  The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either
//  down or right at any point in time.
//
//  Given the two integers m and n, return the number of possible unique paths that the robot can take to reach
//  the bottom-right corner.
//
//  The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
//
//  Example 1:
//    Input: m = 3, n = 2
//    Output: 3
//    Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
//    1. Right -> Down -> Down
//    2. Down -> Down -> Right
//    3. Down -> Right -> Down
//----------------------------------------------------------------------------------------------------------------------

package Problem62;

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 4;
        int n = 7;

        System.out.println(uniquePaths(m,n));
    }

    public static int uniquePaths(int m, int n) {
        int[] previousRow = new int[n];
        Arrays.fill(previousRow, 1);

        // Each cell's unique solution count is equal to the sum of the
        // solution counts of the cells directly up and directly left
        for (int row = 1; row < m; row++) {
            int[] currentRow = new int[n];
            currentRow[0] = 1;

            for (int col = 1; col < n; col++) {
                currentRow[col] = previousRow[col] + currentRow[col - 1];
            }

            // Set new previous row for next iteration
            previousRow = currentRow;
        }

        return previousRow[n - 1];
    }
}
