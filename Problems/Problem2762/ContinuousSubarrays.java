//----------------------------------------------------------------------------------------------------------------------
//  2762. Continuous Subarrays
//
//  You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
//
//  - Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j,
//    0 <= |nums[i1] - nums[i2]| <= 2.
//
//  Return the total number of continuous subarrays.
//
//  A subarray is a contiguous non-empty sequence of elements within an array.
//
//  Example 1:
//    Input: nums = [5,4,2,4]
//    Output: 8
//    Explanation:
//    Continuous subarray of size 1: [5], [4], [2], [4].
//    Continuous subarray of size 2: [5,4], [4,2], [2,4].
//    Continuous subarray of size 3: [4,2,4].
//    There are no subarrys of size 4.
//    Total continuous subarrays = 4 + 3 + 1 = 8.
//    It can be shown that there are no more continuous subarrays.
//----------------------------------------------------------------------------------------------------------------------

package Problem2762;

public class ContinuousSubarrays {
    public static void main(String[] args) {
        int[] nums = {5, 4, 2, 4};

        System.out.println(continuousSubarrays(nums));
    }

    public static long continuousSubarrays(int[] nums) {
        return 0;
    }
}
