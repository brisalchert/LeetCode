//----------------------------------------------------------------------------------------------------------------------
//  3264. Final Array State After K Multiplication Operations I
//
//  You are given an integer array nums, an integer k, and an integer multiplier.
//
//  You need to perform k operations on nums. In each operation:
//
//  - Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that
//    appears first.
//  - Replace the selected minimum value x with x * multiplier.
//
//  Return an integer array denoting the final state of nums after performing all k operations.
//
//  Example 1:
//    Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
//    Output: [8,4,6,5,6]
//----------------------------------------------------------------------------------------------------------------------

package Problem3264;

import java.util.Arrays;

public class ArrayStateAfterMultiplication {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;

        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int minIndex = getMinIndex(nums);
            nums[minIndex] *= multiplier;
        }

        return nums;
    }

    public static int getMinIndex(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
