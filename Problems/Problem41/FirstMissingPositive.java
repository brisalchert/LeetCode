//----------------------------------------------------------------------------------------------------------------------
//  41. First Missing Positive
//
//  Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//  You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
//  Example 1:
//    Input: nums = [1,2,0]
//    Output: 3
//    Explanation: The numbers in the range [1,2] are all in the array.
//----------------------------------------------------------------------------------------------------------------------

package Problem41;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        // First iteration: swap non-duplicate positives (within output range) to their "correct" locations
        int index = 0;

        while (index < nums.length) {
            if (0 < nums[index] && nums[index] <= nums.length) {
                int value = nums[index];

                // Check if non-duplicate
                if (nums[value - 1] != value) {
                    // Swap values
                    int temp = nums[value - 1];
                    nums[value - 1] = value;
                    nums[index] = temp;
                    continue;
                }
            }

            // Only increment index if no swap was made
            index++;
        }

        // Second iteration: find first missing positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If no positives are missing, return the next positive
        return nums.length + 1;
    }
}
