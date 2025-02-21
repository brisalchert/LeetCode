//----------------------------------------------------------------------------------------------------------------------
//  63. Unique Paths II
//
//  You are given an m x n integer array grid. There is a robot initially located in the top-left corner
//  (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot
//  can only move either down or right at any point in time.
//
//  An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any
//  square that is an obstacle.
//
//  Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//  The testcases are generated so that the answer will be less than or equal to 2 * 10^9.
//
//  Example 1:
//    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//    Output: 2
//    Explanation: There is one obstacle in the middle of the 3x3 grid above.
//    There are two ways to reach the bottom-right corner:
//    1. Right -> Right -> Down -> Down
//    2. Down -> Down -> Right -> Right
//----------------------------------------------------------------------------------------------------------------------

package Problem63;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] previousRow = new int[n];
        int[] currentRow = new int[n];
        previousRow[0] = 1; // Assume one way to reach the starting point

        // Each cell's unique solution count is equal to the sum of the
        // solution counts of the cells directly up and directly left
        for (int row = 0; row < m; row++) {
            currentRow[0] = (obstacleGrid[row][0] == 1) ? 0 : previousRow[0];

            for (int col = 1; col < n; col++) {
                currentRow[col] = (obstacleGrid[row][col] == 1) ? 0 : currentRow[col - 1] + previousRow[col];
            }

            // Set new previous row for next iteration
            System.arraycopy(currentRow, 0, previousRow, 0, n);
        }

        return previousRow[n - 1];
    }
}
