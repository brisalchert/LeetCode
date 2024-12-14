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
//    There are no subarrays of size 4.
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
        // If array is empty, return 0
        if (nums == null || nums.length == 0) return 0;

        long subarrayCount = 0;

        // Add all single-element subarrays to count
        subarrayCount += nums.length;

        int i = 0, j = 1;
        int max = nums[i];
        int min = nums[i];

        // Add counts of continuous subarrays until the end of the array is reached
        while (j < nums.length) {
            // Get new max and min
            max = Math.max(max, nums[j]);
            min = Math.min(min, nums[j]);

            // Check if the current subarray is valid
            if (max - min <= 2) {
                // Add all new valid subarrays (equal to j - i)
                subarrayCount += j - i;
            } else {
                // Set i equal to j and backtrack to find skipped valid subarrays
                i = j;
                max = nums[j];
                min = nums[j];

                while (true) {
                    // Ensure outer max and min are only overridden for valid subarrays
                    int newMax = Math.max(max, nums[i - 1]);
                    int newMin = Math.min(min, nums[i - 1]);

                    if (newMax - newMin <= 2) {
                        max = newMax;
                        min = newMin;
                        i--;
                        subarrayCount++;
                    } else {
                        break;
                    }
                }
            }

            // Increment j and check next subarray
            j++;
        }

        return subarrayCount;
    }
}
