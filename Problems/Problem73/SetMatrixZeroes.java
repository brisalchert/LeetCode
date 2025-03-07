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

import java.util.ArrayList;
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
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row and column for top-left flags
        for (int[] row : matrix) {
            if (row[0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Record row and column indices of 0s using the first row and column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Update matrix with new 0s
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Update first row and column
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
