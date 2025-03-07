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
        ArrayList<Integer> columnIndices = new ArrayList<>();

        // Fill rows and record column indices
        for (int[] row : matrix) {
            int currentZeroes = columnIndices.size();

            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    columnIndices.add(j);
                }
            }

            if (columnIndices.size() > currentZeroes) {
                Arrays.fill(row, 0);
            }
        }

        // Fill columns
        for (int i = 0; i < matrix.length; i++) {
            for (int column : columnIndices) {
                matrix[i][column] = 0;
            }
        }
    }
}
