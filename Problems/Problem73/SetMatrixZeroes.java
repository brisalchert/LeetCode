//----------------------------------------------------------------------------------------------------------------------
//  73. Set Matrix Zeroes
//
//  Given an m x n integer matrix, if an element is 0, set its entire row and column to 0's.
//
//  You must do it in place.
//
//  Example 1:
//    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
//    Output: [[1,0,1],[0,0,0],[1,0,1]]
//----------------------------------------------------------------------------------------------------------------------

package Problem73;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String [] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

        setZeroes(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void setZeroes(int[][] matrix) {

    }
}
