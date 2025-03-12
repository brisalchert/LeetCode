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

        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }
}
