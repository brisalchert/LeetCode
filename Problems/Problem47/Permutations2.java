//----------------------------------------------------------------------------------------------------------------------
//  47. Permutations II
//
//  Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations
//  in any order.
//
//  Example 1:
//    Input: nums = [1,1,2]
//    Output:
//    [[1,1,2],
//     [1,2,1],
//     [2,1,1]]
//----------------------------------------------------------------------------------------------------------------------

package Problem47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        // Sort so duplicates are adjacent
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            visited.add(false);
        }

        permuteUniqueHelper(nums, visited, permutation, result);

        return result;
    }

    private static void permuteUniqueHelper(int[] nums, List<Boolean> visited, List<Integer> permutation,
                                            List<List<Integer>> result) {
        // Base case: if permutation is complete, add it to the output
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));

            return;
        }

        // Recursive case: Add each unvisited value to the permutation,
        // skipping duplicates in the same recursion level
        for (int i = 0; i < nums.length; i++) {
            if (visited.get(i)) {
                continue;
            }

            // Skip duplicates within current recursion level
            if (i > 0 && nums[i] == nums[i - 1] && !visited.get(i - 1)) {
                continue;
            }

            permutation.add(nums[i]);
            visited.set(i, true);
            permuteUniqueHelper(nums, visited, permutation, result);
            permutation.remove(permutation.size() - 1);
            visited.set(i, false);
        }
    }
}
