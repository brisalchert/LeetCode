//----------------------------------------------------------------------------------------------------------------------
//  77. Combinations
//
//  Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//
//  You may return the answer in any order.
//
//  Example 1:
//    Input: n = 4, k = 2
//    Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//    Explanation: There are 4 choose 2 = 6 total combinations.
//    Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
//----------------------------------------------------------------------------------------------------------------------

package Problem77;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        System.out.println(combine(n, k));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        combineHelper(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private static void combineHelper(int n, int k, int next, List<Integer> currList, List<List<Integer>> result) {
        if (currList.size() == k) {
            result.add(new ArrayList<>(currList));

            return;
        }

        int numsLeft = k - currList.size();

        // Add one of the remaining elements and continue recursively
        for (int j = next; j <= n - numsLeft + 1; j++) {
            currList.add(j);
            combineHelper(n, k, j + 1, currList, result);
            currList.remove(currList.size() - 1);
        }
    }
}
