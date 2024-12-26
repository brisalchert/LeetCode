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
        // Get total sum of array
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Check if target impossible
        if ((sum - target) % 2 == 1 || target > sum) {
            return 0;
        }

        // Calculate amount to negate ((sum - target) / 2)
        int negateSum = (sum - target) / 2;

        // Create Tabulation array
        int[][] tab = new int[nums.length + 1][negateSum + 1];
        tab[0][0] = 1;

        // Tabulate num combinations for each number of elements
        for (int numElements = 1; numElements <= nums.length; numElements++) {
            // Tabulate num combinations for each possible sum between 0 and negateSum
            for (int targetSum = 0; targetSum <= negateSum; targetSum++) {
                // Check if current value can contribute to negateSum
                if (nums[numElements - 1] <= targetSum) {
                    // Set num solutions to previous solutions + new solutions
                    tab[numElements][targetSum] = tab[numElements - 1][targetSum]
                            + tab[numElements - 1][targetSum - nums[numElements - 1]];
                } else {
                    // Set num solutions to previous solutions
                    tab[numElements][targetSum] = tab[numElements - 1][targetSum];
                }
            }
        }

        // Return number of valid solutions
        return tab[nums.length][negateSum];
    }
}
