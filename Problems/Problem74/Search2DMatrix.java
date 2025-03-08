//----------------------------------------------------------------------------------------------------------------------
//  74. Search a 2D Matrix
//
//  You are given an m x n integer matrix with the following two properties:
//
//  - Each row is sorted in non-decreasing order.
//  - The first integer of each row is greater than the last integer of the previous row.
//
//  Given an integer target, return true if target is in matrix or false otherwise.
//
//  You must write a solution in O(log(m * n)) time complexity.
//
//  Example 1:
//    Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//    Output: true
//----------------------------------------------------------------------------------------------------------------------

package Problem74;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };

        int target = 3;

        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1;

        // Perform binary search on first column
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }

            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (right < 0) return false; // Target does not exist if first value in matrix is greater than it

        int rowIndex = right;
        left = 0;
        right = n - 1;

        // Perform binary search on relevant row
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (matrix[rowIndex][mid] == target) {
                return true;
            }

            if (matrix[rowIndex][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
