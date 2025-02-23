//----------------------------------------------------------------------------------------------------------------------
//  64. Minimum Path Sum
//
//  Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes
//  the sum of all numbers along its path.
//
//  Note: You can only move either down or right at any point in time.
//
//  Example 1:
//    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
//    Output: 7
//    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
//----------------------------------------------------------------------------------------------------------------------

package Problem64;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m =  grid.length;
        int n = grid[0].length;
        int[] currentRow = new int[n];
        currentRow[0] = grid[0][0];

        // Initialize starting values for each column
        for (int col = 1; col < n; col++) {
            currentRow[col] = currentRow[col - 1] + grid[0][col];
        }

        for (int row = 1; row < m; row++) {
            currentRow[0] += grid[row][0];

            for (int col = 1; col < n; col++) {
                currentRow[col] = grid[row][col] + Math.min(currentRow[col], currentRow[col - 1]);
            }
        }

        return currentRow[n - 1];
    }
}
