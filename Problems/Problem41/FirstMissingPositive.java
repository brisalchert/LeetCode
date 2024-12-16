//----------------------------------------------------------------------------------------------------------------------
//  41. First Missing Positive
//
//  Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//  You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
//  Example 1:
//    Input: nums = [1,2,0]
//    Output: 3
//    Explanation: The numbers in the range [1,2] are all in the array.
//----------------------------------------------------------------------------------------------------------------------

package Problem41;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        return 1;
    }
}
