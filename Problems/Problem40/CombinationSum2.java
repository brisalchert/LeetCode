//----------------------------------------------------------------------------------------------------------------------
//  40. Combination Sum II
//
//  Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
//  in candidates where the candidate numbers sum to target.
//
//  Each number in candidates may only be used once in the combination.
//
//  Note: The solution set must not contain duplicate combinations.
//
//  Example 1:
//    Input: candidates = [10,1,2,7,6,1,5], target = 8
//    Output:
//    [
//      [1,1,6],
//      [1,2,5],
//      [1,7],
//      [2,6]
//    ]
//----------------------------------------------------------------------------------------------------------------------

package Problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            // Skip duplicate elements, which will be adjacent due to sorting
            if (i > currentIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Add the current element to the current combination
            current.add(candidates[i]);

            // Call recursively with new diff to find new unique combinations
            combinationHelper(candidates, diff - candidates[i], result, current, i + 1);

            // Remove the current element from the current combination
            current.remove(current.size() - 1);
        }
    }
}
