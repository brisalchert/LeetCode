//----------------------------------------------------------------------------------------------------------------------
//  75. Sort Colors
//
//  Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same
//  color are adjacent, with the colors in the order red, white, and blue.
//
//  We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//  You must solve this problem without using the library's sort function.
//
//  Example 1:
//    Input: nums = [2,0,2,1,1,0]
//    Output: [0,0,1,1,2,2]
//----------------------------------------------------------------------------------------------------------------------

package Problem75;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};

        sortColors(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
    }
}
