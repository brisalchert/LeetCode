//----------------------------------------------------------------------------------------------------------------------
//  26. Remove Duplicates from Sorted Array
//
//  Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
//  element appears only once. The relative order of the elements should be kept the same. Then return the number of
//  unique elements in nums.
//
//  Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//  - Change the array nums such that the first k elements of nums contain the unique elements in the order they were
//    present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//  - Return k.
//
//  Example 1:
//    Input: nums = [1,1,2]
//    Output: 2, nums = [1,2,_]
//    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
//    It does not matter what you leave beyond the returned k (hence they are underscores).
//----------------------------------------------------------------------------------------------------------------------

package Problem26;

public class RemoveDuplicatesSortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        // Create an index for the next unique value
        int uniqueIndex = 1;

        // Iterate through the array, finding and placing the unique values
        for (int i = 1; i < nums.length; i++) {
            // Check for a new unique value
            if (nums[i] != nums[i - 1]) {
                // Place the new value and increment uniqueIndex
                nums[uniqueIndex] = nums[i];
                uniqueIndex++;
            }
        }

        // Once all elements have been seen, return the count of unique elements
        return uniqueIndex;
    }
}
