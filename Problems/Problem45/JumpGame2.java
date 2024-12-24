//----------------------------------------------------------------------------------------------------------------------
//  45. Jump Game II
//
//  You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
//
//  Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are
//  at nums[i], you can jump to any nums[i + j] where:
//
//  - 0 <= j <= nums[i] and
//  - i + j < n
//
//  Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can
//  reach nums[n - 1].
//
//  Example 1:
//    Input: nums = [2,3,1,1,4]
//    Output: 2
//    Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3
//    steps to the last index.
//----------------------------------------------------------------------------------------------------------------------

package Problem45;

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int index = 0;
        int count = 0;

        while (index < nums.length - 1) {
            int maxReachable = index + nums[index];
            int targetJump = index + nums[index];

            // If end is reachable, jump to it
            if (maxReachable >= nums.length - 1) {
                index = nums.length - 1;
                count++;
                continue;
            }

            // Find the furthest reaching jump
            for (int j = index + 1; (j < nums.length && j <= index + nums[index]); j++) {
                if (j + nums[j] > maxReachable) {
                    maxReachable = j + nums[j];
                    targetJump = j;
                }
            }

            index = targetJump;
            count++;
        }

        return count;
    }
}
