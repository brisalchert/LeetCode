//----------------------------------------------------------------------------------------------------------------------
//  57. Insert Interval
//
//  You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the
//  start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given
//  an interval newInterval = [start, end] that represents the start and end of another interval.
//
//  Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and
//  intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
//  Return intervals after the insertion.
//
//  Note that you don't need to modify intervals in-place. You can make a new array and return it.
//
//  Example 1:
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//----------------------------------------------------------------------------------------------------------------------

package Problem57;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {3, 5},
                {6, 7},
                {8, 10},
                {12, 16}
        };

        int[] newInterval = {4, 8};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));

        // Get insertion index
        int insertIndex = binarySearchInterval(intervalList, newInterval, 0, intervals.length - 1);

        // Check if it is a merge or an insert
        if (insertIndex < intervalList.size() &&
                intervalList.get(insertIndex)[1] >= newInterval[0] &&
                intervalList.get(insertIndex)[0] <= newInterval[0]) {
            intervalList.get(insertIndex)[1] = Math.max(intervalList.get(insertIndex)[1], newInterval[1]);
        } else {
            intervalList.add(insertIndex, newInterval);
        }

        // Check if the new interval can be merged with greater intervals
        while (insertIndex + 1 < intervalList.size() &&
                intervalList.get(insertIndex)[1] >= intervalList.get(insertIndex + 1)[0]) {
            intervalList.get(insertIndex)[1] = Math.max(intervalList.get(insertIndex + 1)[1], intervalList.get(insertIndex)[1]);

            intervalList.remove(insertIndex + 1);
        }

        return intervalList.toArray(new int[intervalList.size()][]);
    }

    private static int binarySearchInterval(ArrayList<int[]> intervals, int[] newInterval, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            // Check if newInterval[start] fits in the interval at mid
            if (intervals.get(mid)[1] >= newInterval[0] && intervals.get(mid)[0] <= newInterval[0]) {
                return mid;
            }

            // Check if newInterval is entirely smaller than mid
            if (newInterval[0] < intervals.get(mid)[1]) {
                return binarySearchInterval(intervals, newInterval, low, mid - 1);
            }

            return binarySearchInterval(intervals, newInterval, mid + 1, high);
        }

        // Return index where insertion should occur
        return low;
    }
}
