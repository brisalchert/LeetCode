//----------------------------------------------------------------------------------------------------------------------
//  70. Climbing Stairs
//
//  You are climbing a staircase. It takes n steps to reach the top.
//
//  Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//  Example 1:
//    Input: n = 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//    1. 1 step + 1 step
//    2. 2 steps
//
//  Example 2:
//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//    1. 1 step + 1 step + 1 step
//    2. 1 step + 2 steps
//    3. 2 steps + 1 step
//----------------------------------------------------------------------------------------------------------------------

package Problem70;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int[] memo = new int[n + 1];
        return climbStairs(n, memo);
    }

    private static int climbStairs(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];

        memo[n - 1] = climbStairs(n - 1, memo);
        memo[n - 2] = climbStairs(n - 2, memo);
        memo[n] = memo[n - 1] + memo[n - 2];

        return memo[n];
    }
}
