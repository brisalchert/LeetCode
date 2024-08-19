//----------------------------------------------------------------------------------------------------------------------
//  15. 3Sum
//
//  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and
//  j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//  Notice that the solution set must not contain duplicate triplets.
//----------------------------------------------------------------------------------------------------------------------

package Problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> result = threeSum(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // Sort the input so that duplicate triplets will be identical arrays
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);

                        if (!result.contains(list)) {
                            result.add(list);
                        }
                    }
                }
            }
        }

        return result;
    }
}
