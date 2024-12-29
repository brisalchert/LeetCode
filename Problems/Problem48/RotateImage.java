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
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
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
    }
}
