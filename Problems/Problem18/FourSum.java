//----------------------------------------------------------------------------------------------------------------------
//  18. 4Sum
//
//  Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c],
//  nums[d]] such that:
//
//    0 <= a, b, c, d < n
//    a, b, c, and d are distinct.
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//
//  You may return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        long start = System.nanoTime();
        System.out.println(fourSum(nums, target));
        long end = System.nanoTime();

        System.out.println((end - start) / 1000000 + " ms");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the input array
        Arrays.sort(nums);

        // Fix the first two indices
        for (int i = 0; i < nums.length - 3; i++) {
            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Skip duplicate values
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1;
                int l = nums.length - 1;

                // Use two pointers to check all unique sums
                while (k < l) {
                    // Prevent integer overflow when summing values
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));

                        // Increment the left pointer, skipping duplicates
                        do {
                            k++;
                        } while (k < l && nums[k] == nums[k - 1]);
                    } else if (sum < target) {
                        // If the sum is too low, increment the left pointer
                        k++;
                    } else {
                        // If the sum is too high, decrement the right pointer
                        l--;
                    }
                }
            }
        }

        return result;
    }
}
