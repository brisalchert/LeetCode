//----------------------------------------------------------------------------------------------------------------------
//  39. Combination Sum
//
//  Given an array of distinct integers candidates and a target integer target, return a list of all unique
//  combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//  The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//  frequency of at least one of the chosen numbers is different.
//
//  The test cases are generated such that the number of unique combinations that sum up to target is less than 150
//  combinations for the given input.
//
//  Example 1:
//    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]
//    Explanation:
//    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//    7 is a candidate, and 7 = 7.
//    These are the only two combinations.
//----------------------------------------------------------------------------------------------------------------------

package Problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort the candidates array
        Arrays.sort(candidates);

        // Create result list
        List<List<Integer>> result = new ArrayList<>();

        // Call helper function to find all unique combinations
        combinationHelper(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }

    private static void combinationHelper(int[] candidates, int diff, List<List<Integer>> result,
                                          List<Integer> current, int currentIndex) {
        // If diff < 0, current combination is invalid
        if (diff < 0) {
            return;
        }

        // If diff == 0, current combination is valid
        if (diff == 0) {
            result.add(new ArrayList<>(current));

            return;
        }

        // Otherwise, try subsequent combinations starting with the current element
        for (int i = currentIndex; i < candidates.length; i++) {
            // Add the current element to the current combination
            current.add(candidates[i]);

            // Call recursively with new diff to find new unique combinations
            int newDiff = diff - candidates[i];
            combinationHelper(candidates, newDiff, result, current, i); // Use i to allow reusing elements

            // Remove the current element from the current combination
            current.remove(current.size() - 1);
        }
    }
}
