//----------------------------------------------------------------------------------------------------------------------
//  54. Spiral Matrix
//
//  Given an m x n matrix, return all elements of the matrix in spiral order.
//
//  Example 1:
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [1,2,3,6,9,8,7,4,5]
//----------------------------------------------------------------------------------------------------------------------

package Problem54;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int level = 0;

        while (level < (Math.min(m + 1, n + 1) / 2)) {
            int i = level;
            int j = level;

            // Always add first element of a given level
            result.add(matrix[i][j]);

            while (j < n - level - 1) {
                j++;
                result.add(matrix[i][j]);
            }

            while (i < m - level - 1) {
                i++;
                result.add(matrix[i][j]);
            }

            if (level < (m / 2)) {
                while (j > level) {
                    j--;
                    result.add(matrix[i][j]);
                }
            }

            if (level < (n / 2)) {
                while (i > level + 1) {
                    i--;
                    result.add(matrix[i][j]);
                }
            }

            level++;
        }

        return result;
    }
}
