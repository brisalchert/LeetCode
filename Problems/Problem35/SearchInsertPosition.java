//----------------------------------------------------------------------------------------------------------------------
//  35. Search Insert Position
//
//  Given a sorted array of distinct integers and a target value, return the index if the target is found. If not,
//  return the index where it would be if it were inserted in order.
//
//  You must write an algorithm with O(log n) runtime complexity.
//
//  Example 1:
//    Input: nums = [1,3,5,6], target = 5
//    Output: 2
//
//  Example 2:
//    Input: nums = [1,3,5,6], target = 2
//    Output: 1
//----------------------------------------------------------------------------------------------------------------------

package Problem35;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 8, 9, 11, 12};
        int target = 6;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        // Perform binary search for target
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // If target was not found, the insert index is equal to low
        return low;
    }
}
