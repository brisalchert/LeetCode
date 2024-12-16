//----------------------------------------------------------------------------------------------------------------------
//  3264. Final Array State After K Multiplication Operations I
//
//  You are given an integer array nums, an integer k, and an integer multiplier.
//
//  You need to perform k operations on nums. In each operation:
//
//  - Find the minimum value x in nums. If there are multiple occurrences of the minimum value, select the one that
//    appears first.
//  - Replace the selected minimum value x with x * multiplier.
//
//  Return an integer array denoting the final state of nums after performing all k operations.
//
//  Example 1:
//    Input: nums = [2,1,3,5,6], k = 5, multiplier = 2
//    Output: [8,4,6,5,6]
//----------------------------------------------------------------------------------------------------------------------

package Problem3264;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ArrayStateAfterMultiplication {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;

        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<NumRecord> numPQ = new PriorityQueue<>();

        // Put all values in nums into a min heap
        for (int i = 0; i < nums.length; i++) {
            NumRecord record = new NumRecord(nums[i], i);
            numPQ.offer(record);
        }

        // For each operation, multiply the minimum element and put it back on the heap
        for (int i = 0; i < k; i++) {
            NumRecord record = numPQ.remove();
            record.num *= multiplier;
            nums[record.index] = record.num;
            numPQ.offer(record);
        }

        return nums;
    }

    static class NumRecord implements Comparable<NumRecord> {
        public int num;
        public int index;

        public NumRecord(int num, int index) {
            this.num = num;
            this.index = index;
        }

        @Override
        public int compareTo(NumRecord other) {
            int result = Integer.compare(this.num, other.num);

            // Use index for comparison in the case of equal values
            if (result == 0) {
                result = Integer.compare(this.index, other.index);
            }

            return result;
        }
    }
}
