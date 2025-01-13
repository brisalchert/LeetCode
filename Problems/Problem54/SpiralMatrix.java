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
        return null;
    }
}
