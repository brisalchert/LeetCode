//----------------------------------------------------------------------------------------------------------------------
//  55. Jump Game
//
//  You are given an integer array nums. You are initially positioned at the array's first index, and each element
//  in the array represents your maximum jump length at that position.
//
//  Return true if you can reach the last index, or false otherwise.
//
//  Example 1:
//    Input: nums = [2,3,1,1,4]
//    Output: true
//    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
//----------------------------------------------------------------------------------------------------------------------

package Problem55;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};

        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int moves = 0;

        for (int num : nums) {
            if (moves < 0) {
                return false;
            }

            // Replenish moves remaining if possible
            if (num > moves) {
                moves = num;
            }

            moves--;
        }

        return true;
    }
}
