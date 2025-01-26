//----------------------------------------------------------------------------------------------------------------------
//  59. Spiral Matrix II
//
//  Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
//
//  Example 1:
//    Input: n = 3
//    Output: [[1,2,3],[8,9,4],[7,6,5]]
//----------------------------------------------------------------------------------------------------------------------

package Problem59;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int level = 0;
        int value = 1;

        while (level < (n + 1) / 2) {
            int i = level;
            int j = level;

            // Always add first element of a given level
            matrix[i][j] = value;
            value++;

            while (j < n - level - 1) {
                j++;
                matrix[i][j] = value;
                value++;
            }

            while (i < n - level - 1) {
                i++;
                matrix[i][j] = value;
                value++;
            }

            while (j > level) {
                j--;
                matrix[i][j] = value;
                value++;
            }

            while (i > level + 1) {
                i--;
                matrix[i][j] = value;
                value++;
            }

            level++;
        }

        return matrix;
    }
}
