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
        int target = 7;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Return if nums is empty
        if (nums == null || nums.length == 0) return result;

        // Use binary search to find the lowest index of target
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // Keep moving high index down until low == high
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // Check if the target was not found
        if (nums[low] != target) {
            return result;
        }

        result[0] = low;

        // Use binary search to find the highest index of target
        high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2 + 1; // Give mid a right-bias

            // Keep moving high index down until low == high
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid; // Right-bias ensures this does not loop infinitely
            }
        }

        result[1] = high;

        // Return the indices
        return result;
    }
}
