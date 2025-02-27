//----------------------------------------------------------------------------------------------------------------------
//  873. Length of Longest Fibonacci Subsequence
//
//  A sequence x1, x2, ..., xn is Fibonacci-like if:
//  - n >= 3
//  - xi + xi+1 == xi+2 for all i + 2 <= n
//
//  Given a strictly increasing array arr of positive integers forming a sequence, return the length of the longest
//  Fibonacci-like subsequence of arr. If one does not exist, return 0.
//
//  A subsequence is derived from another sequence arr by deleting any number of elements (including none) from
//  arr, without changing the order of the remaining elements. For example, [3, 5, 8] is a subsequence of
//  [3, 4, 5, 6, 7, 8].
//
//  Example 1:
//    Input: arr = [1,2,3,4,5,6,7,8]
//    Output: 5
//    Explanation: The longest subsequence that is fibonacci-like: [1,2,3,5,8].
//
//  Example 2:
//    Input: arr = [1,3,7,11,12,14,18]
//    Output: 3
//    Explanation: The longest subsequence that is fibonacci-like: [1,11,12], [3,11,14] or [7,11,18].
//----------------------------------------------------------------------------------------------------------------------

package Problem873;

import java.util.Arrays;
import java.util.HashMap;

public class LongestFibSequence {
    public static void main (String[] args) {
        int[] arr = {1,3,7,11,12,14,18};

        System.out.println(lenLongestFibSubseq(arr));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        HashMap<Integer, Integer> valueToIndex = new HashMap<>();
        int result = 0;

        // Fill DP table with values of 2 (for minimum Fib sequence length)
        Arrays.stream(dp).forEach(A -> Arrays.fill(A, 2));

        // Initialize valueToIndex HashMap
        for (int i = 0; i < arr.length; i++) {
            valueToIndex.put(arr[i], i);
        }

        // Iterate through all pairs, incrementing sequence lengths in DP table
        for (int j = 1; j < arr.length; j++) {
            int fib1 = arr[j];

            for (int k = j + 1; k < arr.length; k++) {
                int fib2 = arr[k];
                int fib0 = fib2 - fib1;

                if (fib0 >= fib1) break; // Sequence impossible

                if (valueToIndex.containsKey(fib0)) {
                    int i = valueToIndex.get(fib0);
                    dp[j][k] = dp[i][j] + 1;
                }

                result = Math.max(result, dp[j][k]);
            }
        }

        // Prevent invalid result values
        return (result > 2) ? result : 0;
    }
}
