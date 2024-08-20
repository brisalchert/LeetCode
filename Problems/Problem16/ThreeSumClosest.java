//----------------------------------------------------------------------------------------------------------------------
//  15. 3Sum Closest
//
//  Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
//  closest to target.
//
//  Return the sum of the three integers.
//
//  You may assume that each input would have exactly one solution.
//----------------------------------------------------------------------------------------------------------------------

package Problem16;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        long start = System.nanoTime();
        System.out.println(threeSumClosest(nums, target));
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000 + " ms");
    }

    public static int threeSumClosest(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];

        // Sort the input array
        Arrays.sort(nums);

        // Fix the first index for each iteration
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            // Use two pointers to move the sum
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == target) {
                    // Return if target sum is found
                    return sum;
                } else if (sum > target) {
                    // If sum is too large, decrement larger index
                    k--;
                } else {
                    // If sum is too small, increment smaller index
                    j++;
                }

                // Set the new closest sum if needed
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }
            }
        }

        return closestSum;
    }
}
