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

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {6, 9}
        };

        int[] newInterval = {2, 5};

        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        return null;
    }
}
