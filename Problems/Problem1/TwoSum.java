//----------------------------------------------------------------------------------------------------------------------
//  1. Two Sum
//
//  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//  You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//  You can return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Problem1;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;

        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    /**
     * Returns the indices of a pair of numbers in an array with sum target
     * @param nums the array of numbers
     * @param target the target sum
     * @return an array of the indices of the pair with sum target
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        // Look for pairs one value at a time
        for (int index = 0; index < nums.length; index++) {
            int diff = target - nums[index];

            // Look to see if the difference has been previously seen
            if (numMap.containsKey(diff)) {
                // Return the indices of the pair
                return new int[] {numMap.get(diff), index};
            }

            // Add the unpaired value to the HashMap
            numMap.put(nums[index], index);
        }

        // Return an empty array if no pair is found
        return new int[] {};
    }
}
