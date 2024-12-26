//----------------------------------------------------------------------------------------------------------------------
//  46. Permutations
//
//  Given an array nums of distinct integers, return all the possible permutations. You can return the answer
//  in any order.
//
//  Example 1:
//    Input: nums = [1,2,3]
//    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//----------------------------------------------------------------------------------------------------------------------

package Problem46;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        permuteHelper(nums, new ArrayList<>(), result);

        return result;
    }

    private static void permuteHelper(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        // Base case: if permutation is complete, add it to the output
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));

            return;
        }

        // Recursive case: Try each remaining value and get further permutations
        for (int num : nums) {
            if (!permutation.contains(num)) {
                permutation.add(num);
                permuteHelper(nums, permutation, result);
                permutation.remove(permutation.size() - 1);
            }
        }
    }
}
