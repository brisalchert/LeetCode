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

        permuteHelper(nums, 0, result);

        return result;
    }

    private static void permuteHelper(int[] nums, int startIndex, List<List<Integer>> result) {
        // Base case: if permutation is complete, add it to the output
        if (startIndex == nums.length) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) {
                permutation.add(num);
            }

            result.add(permutation);

            return;
        }

        // Recursive case: put each remaining value at startIndex and call recursively
        for (int i = startIndex; i < nums.length; i++) {
            swap(nums, startIndex, i);
            permuteHelper(nums, startIndex + 1, result);
            swap(nums, startIndex, i);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
