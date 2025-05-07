//----------------------------------------------------------------------------------------------------------------------
//  3341. Find Minimum Time to Reach Last Room I
//
//  There is a dungeon with n x m rooms arranged as a grid.
//
//  You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds
//  when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent
//  room. Moving between adjacent rooms takes exactly one second.
//
//  Return the minimum time to reach the room (n - 1, m - 1).
//
//  Two rooms are adjacent if they share a common wall, either horizontally or vertically.
//
//  Example 1:
//    Input: moveTime = [[0,4],[4,4]]
//    Output: 6
//    Explanation:
//      The minimum time required is 6 seconds.
//      At time t == 4, move from room (0, 0) to room (1, 0) in one second.
//      At time t == 5, move from room (1, 0) to room (1, 1) in one second.
//----------------------------------------------------------------------------------------------------------------------

package Problem3341;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumTimeLastRoom {
    public static void main(String[] args) {
        int[][] moveTime = {
                {0,4},
                {4,4}
        };

        System.out.println(minTimeToReach(moveTime));
    }

    public static int minTimeToReach(int[][] moveTime) {
        int[][] times = new int[moveTime.length][moveTime[0].length];
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] row : times) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        times[0][0] = 0;

        pq.offer(new int[] {0,0,0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int i = current[1];
            int j = current[2];

            for (int[] direction : directions) {
                int x = i + direction[0];
                int y = j + direction[1];

                // Ensure cell is valid
                if ((x >= 0 && x < moveTime.length) && (y >= 0 && y < moveTime[0].length)) {
                    // Check for a new quickest path
                    if (Math.max(times[i][j] + 1, moveTime[x][y] + 1) < times[x][y]) {
                        times[x][y] = Math.max(times[i][j] + 1, moveTime[x][y] + 1);

                        // Add new cell to the priority queue
                        pq.offer(new int[] {times[x][y], x, y});
                    }
                }
            }
        }

        return times[moveTime.length - 1][moveTime[0].length - 1];
    }
}
