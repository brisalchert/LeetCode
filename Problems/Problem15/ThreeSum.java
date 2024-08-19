//----------------------------------------------------------------------------------------------------------------------
//  15. 3Sum
//
//  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
//  j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//  Notice that the solution set must not contain duplicate triplets.
//----------------------------------------------------------------------------------------------------------------------

package Problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);

        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Sort the input array
        Arrays.sort(nums);

        // Iterate through each value for the first index
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            // Use two pointers to check all unique sums
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                // If sum is 0, add to result set
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Increment the smaller index, ensuring its value is different from the previous value
                    do {
                        j++;
                    } while (j < k && nums[j] == nums[j - 1]);
                } else if (sum > 0) {
                    // If sum is too high, decrement the larger index
                    k--;
                } else {
                    // If sum is too low, increment the smaller index
                    j++;
                }
            }
        }

        return result;
    }
}
