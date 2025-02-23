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
        int[] previousRow = new int[n];
        int sum = 0;
        for (int j = 0; j < n; j++) {
            sum += grid[0][j];
            previousRow[j] = sum;
        }

        for (int row = 1; row < m; row++) {
            int[] currentRow = new int[n];
            currentRow[0] = grid[row][0] + previousRow[0];

            for (int col = 1; col < n; col++) {
                currentRow[col] = grid[row][col] + Math.min(currentRow[col - 1], previousRow[col]);
            }

            previousRow = currentRow;
        }

        return previousRow[n - 1];
    }
}
