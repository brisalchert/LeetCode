//----------------------------------------------------------------------------------------------------------------------
//  31. Next Permutation
//
//  A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
//
//  - For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3],
//    [2, 3, 1], [3,1,2], [3,2,1].
//
//  The next permutation of an array of integers is the next lexicographically greater permutation of its integer.
//  More formally, if all the permutations of the array are sorted in one container according to their lexicographical
//  order, then the next permutation of that array is the permutation that follows it in the sorted container. If such
//  arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending
//  order).
//
//  - For example, the next permutation of arr = [1,2,3] is [1,3,2].
//  - Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
//  - While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger
//    rearrangement.
//  - Given an array of integers nums, find the next permutation of nums.
//
//  The replacement must be in place and use only constant extra memory.
//----------------------------------------------------------------------------------------------------------------------

package Problem31;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2};

        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        // Initialize index to the second number from the right
        int index = nums.length - 2;

        // Continue moving right until a number less than the current number
        // is found (or the array is exhausted)
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        // If the array is not in fully descending order (index > 0), find the smallest
        // number larger than the number at the index and swap it with index
        if (index >= 0) {
            // Start from the right (due to order of permutations)
            int swapIndex = nums.length - 1;

            while(nums[swapIndex] <= nums[index]) {
                swapIndex--;
            }

            // Swap the values
            swap(nums, index, swapIndex);
        }

        // Reverse all elements to the right of index
        reverse(nums, index + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        // Reverse the array by swapping outermost elements and moving inward
        // until the indices cross
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
