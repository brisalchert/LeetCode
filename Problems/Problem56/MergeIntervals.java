//----------------------------------------------------------------------------------------------------------------------
//  56. Merge Intervals
//
//  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return
//  an array of the non-overlapping intervals that cover all the intervals in the input.
//
//  Example 1:
//    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//----------------------------------------------------------------------------------------------------------------------

package Problem56;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    public static int[][] merge(int[][] intervals) {
        // Sort the intervals by their start values
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int lastMerged = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[lastMerged][1]) {
                intervals[lastMerged][1] = Math.max(intervals[lastMerged][1], intervals[i][1]);
            } else {
                // Replace a previously merged interval with a non-overlapping interval
                lastMerged++;
                intervals[lastMerged] = intervals[i];
            }
        }

        // Return only the merged result
        return Arrays.copyOfRange(intervals, 0, lastMerged + 1);
    }
}
