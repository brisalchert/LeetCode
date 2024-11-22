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
        // Create an index for the last unique number visited
        int uniqueIndex = 0;

        // Keep track of the last unique value encountered
        int lastUnique = nums[0];

        // Iterate through the array, finding and placing the unique values
        for (int i = 0; i < nums.length; i++) {
            // Ignore previously encountered values (array is sorted, so values
            // less than or equal to lastUnique have already been seen)
            if (nums[i] > lastUnique) {
                // Set lastUnique to the new unique value
                lastUnique = nums[i];

                // Increment uniqueIndex and place the new value
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        // Once all elements have been seen, return the count of unique elements
        return uniqueIndex + 1;
    }
}
