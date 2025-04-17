//----------------------------------------------------------------------------------------------------------------------
//  2537. Count the Number of Good Subarrays
//
//  Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//  A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
//
//  A subarray is a contiguous non-empty sequence of elements within an array.
//
//  Example 1:
//    Input: nums = [1,1,1,1,1], k = 10
//    Output: 1
//    Explanation: The only good subarray is the array nums itself.
//
//  Example 2:
//    Input: nums = [3,1,4,3,2,2,4], k = 2
//    Output: 4
//    Explanation: There are 4 different good subarrays:
//    - [3,1,4,3,2,2] that has 2 pairs.
//    - [3,1,4,3,2,2,4] that has 3 pairs.
//    - [1,4,3,2,2,4] that has 2 pairs.
//    - [4,3,2,2,4] that has 2 pairs.
//----------------------------------------------------------------------------------------------------------------------

package Problem2537;

import java.util.HashMap;

public class CountGoodSubarrays {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int k = 2;

        System.out.println(countGood(nums, k));
    }

    public static long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        long result = 0;

        for (int right = 0; right < nums.length; right++) {
            // Account for new pairs with the current element
            k -= countMap.getOrDefault(nums[right], 0);
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);
            // Move the left pointer while there are at least k pairs
            while (k <= 0) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                k += countMap.get(nums[left++]);
            }
            // Add good subarrays starting from [0, left - 1] and ending at right
            result += left;
        }

        return result;
    }
}
