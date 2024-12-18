//----------------------------------------------------------------------------------------------------------------------
//  27. Remove Element
//
//  Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the
//  elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//  Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the
//  following things:
//
//  - Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
//    The remaining elements of nums are not important as well as the size of nums.
//  - Return k.
//
//  Example 1:
//    Input: nums = [3,2,2,3], val = 3
//    Output: 2, nums = [2,2,_,_]
//    Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//    It does not matter what you leave beyond the returned k (hence they are underscores).
//----------------------------------------------------------------------------------------------------------------------

package Problem27;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        // Create an index for kept elements
        int keepIndex = 0;

        // Iterate through the array, removing instances of val and moving kept values
        for (int i = 0; i < nums.length; i++) {
            // If the number is not val, keep it and move it to the end of the kept values
            if (nums[i] != val) {
                nums[keepIndex] = nums[i];
                keepIndex++;
            }
        }

        // Return the number of kept elements
        return keepIndex;
    }
}
