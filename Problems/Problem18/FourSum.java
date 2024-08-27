//----------------------------------------------------------------------------------------------------------------------
//  18. 4Sum
//
//  Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c],
//  nums[d]] such that:
//
//    0 <= a, b, c, d < n
//    a, b, c, and d are distinct.
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//
//  You may return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Problem18;

import java.util.ArrayList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        long start = System.nanoTime();
        System.out.println(fourSum(nums, target));
        long end = System.nanoTime();

        System.out.println((end - start) / 1000000 + " ms");
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        return result;
    }
}
