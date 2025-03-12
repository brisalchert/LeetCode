//----------------------------------------------------------------------------------------------------------------------
//  78. Subsets
//
//  Given an integer array nums of unique elements, return all possible subsets (the power set).
//
//  The solution set must not contain duplicate subsets. Return the solution in any order.
//
//  Example 1:
//    Input: nums = [1,2,3]
//    Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//----------------------------------------------------------------------------------------------------------------------

package Problem78;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(subsetsBit(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        // Add the empty set
        subsets.add(new ArrayList<>());

        for (int num : nums) {
            int n = subsets.size();

            for (int i = 0; i < n; i++) {
                // Create a copy of the set in subsets
                List<Integer> subset = new ArrayList<>(subsets.get(i));

                // Add num to the copy and append to subsets
                subset.add(num);
                subsets.add(subset);
            }
        }

        return subsets;
    }

    public static List<List<Integer>> subsetsBit(int[] nums) {
        int n = nums.length, p = 1 << n;
        List<List<Integer>> subsets = new ArrayList<>(p);

        for (int i = 0; i < p; i++) {

            subsets.add(new ArrayList<>());

            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) != 0) {
                    subsets.get(i).add(nums[j]);
                }
            }
        }

        return subsets;
    }
}
