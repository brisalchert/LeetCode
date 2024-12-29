//----------------------------------------------------------------------------------------------------------------------
//  48. Rotate Image
//
//  You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//  You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT
//  allocate another 2D matrix and do the rotation.
//
//  Example 1:
//    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    Output: [[7,4,1],[8,5,2],[9,6,3]]
//----------------------------------------------------------------------------------------------------------------------

package Problem48;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int numLevels = matrix.length / 2;
        int length = matrix.length;

        for (int level = 0; level < numLevels; level++) {
            for (int i = level; i < (length - 1 - level); i++) {
                // Swap four indices at a time
                int temp = matrix[level][i];
                matrix[level][i] = matrix[length - 1 - i][level];
                matrix[length - 1 - i][level] = matrix[length - 1 - level][length - 1 - i];
                matrix[length - 1 - level][length - 1 - i] = matrix[i][length - 1 - level];
                matrix[i][length - 1 - level] = temp;
            }
        }
    }
}
