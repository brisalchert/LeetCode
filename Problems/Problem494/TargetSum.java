//----------------------------------------------------------------------------------------------------------------------
//  494. Target Sum
//
//  You are given an integer array nums and an integer target.
//
//  You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in
//  nums and then concatenate all the integers.
//
//  - For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build
//    the expression "+2-1".
//
//  Return the number of different expressions that you can build, which evaluates to target.
//
//  Example 1:
//    Input: nums = [1,1,1,1,1], target = 3
//    Output: 5
//    Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
//    -1 + 1 + 1 + 1 + 1 = 3
//    +1 - 1 + 1 + 1 + 1 = 3
//    +1 + 1 - 1 + 1 + 1 = 3
//    +1 + 1 + 1 - 1 + 1 = 3
//    +1 + 1 + 1 + 1 - 1 = 3
//----------------------------------------------------------------------------------------------------------------------

package Problem494;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return findTargetHelper(nums, target, 0, 0);
    }

    private static int findTargetHelper(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        int positive = findTargetHelper(nums, target, index + 1, sum + nums[index]);
        int negative = findTargetHelper(nums, target, index + 1, sum - nums[index]);

        return positive + negative;
    }
}
