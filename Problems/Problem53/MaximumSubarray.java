//----------------------------------------------------------------------------------------------------------------------
//  53. Maximum Subarray
//
//  Given an integer array nums, find the subarray with the largest sum, and return its sum.
//
//  Example 1:
//    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
//----------------------------------------------------------------------------------------------------------------------

package Problem53;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        // Initialize pointers and sums
        int left = 0, center = 0, right = 0;
        int sum = nums[0], leftSum = 0;

        // Continue until each number has been the center
        while (center < nums.length) {
            // Add values to the right while they increase the sum
            while (right < nums.length - 1 && nums[right + 1] > 0) {
                right++;
                sum += nums[right];
            }

            // Remove values from the left while they don't increase the sum
            while (left < center && leftSum <= 0) {
                sum -= nums[left];
                leftSum -= nums[left];
                left++;
            }

            // Save the maximum sum
            maxSum = Math.max(maxSum, sum);

            // Increment the center pointer
            if (right < nums.length - 1 && right == center) {
                right++;
                sum += nums[right];
            }

            leftSum += nums[center];
            center++;
        }

        return maxSum;
    }
}
