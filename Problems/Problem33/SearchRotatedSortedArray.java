//----------------------------------------------------------------------------------------------------------------------
//  33. Search in Rotated Sorted Array
//
//  There is an integer array nums sorted in ascending order (with distinct values).
//
//  Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
//  such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//  For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//  Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
//  or -1 if it is not in nums.
//
//  You must write an algorithm with O(log n) runtime complexity.
//
//  Example 1:
//    Input: nums = [4,5,6,7,0,1,2], target = 0
//    Output: 4
//----------------------------------------------------------------------------------------------------------------------

package Problem33;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        // Find the index of the smallest value using a binary search
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // If high > mid, the smallest value is to the right, else it is to the left
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // low == high is the index of the smallest value as well as the number of places
        // rotated, k
        int rotated = low;

        // Perform iterative binary search, accounting for the rotation
        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Get the real midpoint by adding the rotation factor
            int realMid = (mid + rotated) % nums.length;

            if (nums[realMid] == target) {
                return realMid;
            }

            // Check if the value is to the right or left
            if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If target is not found, return -1
        return -1;
    }

    private static int rotatedBinarySearch(int[] nums, int low, int high, int target) {
        // Continue while there are items to check
        if (high >= low) {
            // Calculate the midpoint index
            int mid = low + (high - low) / 2;

            // Compare mid to the target
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                // Check if element should be between mid and high
                if ((nums[low] > target) || (nums[low] <= nums[mid])) {
                    return rotatedBinarySearch(nums, mid + 1, high, target);
                }
            }

            if (nums[mid] > target) {
                // Check if element should be between mid and high
                if ((nums[high] >= target) && (nums[high] < nums[mid])) {
                    return rotatedBinarySearch(nums, mid + 1, high, target);
                }
            }

            // Otherwise, element should be between low and mid
            return rotatedBinarySearch(nums, low, mid - 1, target);
        }

        // If element is not found, return -1
        return -1;
    }
}
