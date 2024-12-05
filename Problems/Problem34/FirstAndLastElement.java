//----------------------------------------------------------------------------------------------------------------------
//  34. Find First and Last Position of Element in Sorted Array
//
//  Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given
//  target value.
//
//  If target is not found in the array, return [-1, -1].
//
//  You must write an algorithm with O(log n) runtime complexity.
//
//  Example 1:
//    Input: nums = [5,7,7,8,8,10], target = 8
//    Output: [3,4]
//
//  Example 2:
//    Input: nums = [5,7,7,8,8,10], target = 6
//    Output: [-1,-1]
//----------------------------------------------------------------------------------------------------------------------

package Problem34;

import java.util.Arrays;

public class FirstAndLastElement {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[]{0};
    }
}
