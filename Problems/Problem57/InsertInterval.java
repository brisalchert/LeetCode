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

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        List<int[]> result = new LinkedList<>();
        int i = 0;

        // Add all non-overlapping intervals before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Mutate newInterval to be the largest merge possible
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // Add all non-overlapping intervals after newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
