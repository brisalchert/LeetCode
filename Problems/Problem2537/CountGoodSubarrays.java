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
        int l = 0, r = 1;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int totalPairs = 0;
        long result = 0;

        // Add the first element
        countMap.put(nums[l], countMap.getOrDefault(nums[l], 0) + 1);

        while (r < nums.length) {
            // Move r to the right until there are at least k pairs
            while (r < nums.length && totalPairs < k) {
                countMap.put(nums[r], countMap.getOrDefault(nums[r], 0) + 1);
                totalPairs += countMap.get(nums[r]) - 1;

                if (totalPairs < k) {
                    r++;
                }
            }

            // Add current subarray and a subarray for each element to the right
            result += (long) nums.length - r;

            // Move l to the right until there are less than k pairs
            while (totalPairs >= k) {
                int currentCount = countMap.get(nums[l]);
                countMap.put(nums[l], currentCount - 1);
                totalPairs -= currentCount - 1;
                l++;

                if (totalPairs >= k) {
                    result += (long) nums.length - r;
                }
            }

            // Increment r to avoid counting the same subarray twice
            r++;
        }

        return result;
    }
}
