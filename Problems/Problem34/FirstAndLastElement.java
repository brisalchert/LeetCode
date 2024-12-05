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
        // Find one instance of target using binary search
        int low = 0, high = nums.length - 1;
        int targetIndex = binarySearch(nums, low, high, target);

        // If target was not found, return [-1, -1]
        if (targetIndex == -1) {
            return new int[] {-1, -1};
        }

        // If target was found, all other instances are within range (low, high)
        int minIndex = targetIndex;
        int minSearch = targetIndex;
        int maxIndex = targetIndex;
        int maxSearch = targetIndex;

        // Continue finding values to the left with binary search
        while (minIndex > 0 && minSearch != -1) {
            minSearch = binarySearch(nums, 0, minIndex - 1, target);

            minIndex = (minSearch != -1) ? minSearch : minIndex;
        }

        // Continue finding values to the right with binary search
        while (maxIndex < nums.length - 1 && maxSearch != -1) {
            maxSearch = binarySearch(nums, maxIndex + 1, nums.length - 1, target);

            maxIndex = (maxSearch != -1) ? maxSearch : maxIndex;
        }

        // Return the min and max indices
        return new int[] {minIndex, maxIndex};
    }

    private static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            }

            if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return -1;
    }
}
