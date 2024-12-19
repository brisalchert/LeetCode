//----------------------------------------------------------------------------------------------------------------------
//  769. Max Chunks To Make Sorted
//
//  You are given an integer array arr of length n that represents a permutation of the integers in the range
//  [0, n - 1].
//
//  We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating
//  them, the result should equal the sorted array.
//
//  Return the largest number of chunks we can make to sort the array.
//
//  Example 1:
//    Input: arr = [4,3,2,1,0]
//    Output: 1
//    Explanation:
//    Splitting into two or more chunks will not return the required result.
//    For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
//----------------------------------------------------------------------------------------------------------------------

package Problem769;

public class MaxChunksToSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};

        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int max = arr[0];
        int chunks = 0;

        // A valid chunk ends when the current maximum value
        // is equal to the current index
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);

            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
