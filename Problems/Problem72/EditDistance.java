//----------------------------------------------------------------------------------------------------------------------
//  72. Edit Distance
//
//  Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
//
//  You have the following three operations permitted on a word:
//
//  - Insert a character
//  - Delete a character
//  - Replace a character
//
//  Example 1:
//    Input: word1 = "horse", word2 = "ros"
//    Output: 3
//    Explanation:
//    horse -> rorse (replace 'h' with 'r')
//    rorse -> rose (remove 'r')
//    rose -> ros (remove 'e')
//----------------------------------------------------------------------------------------------------------------------

package Problem72;

import java.util.Arrays;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[] previousRow = new int[n + 1];
        int[] currentRow = new int[n + 1];

        // Initialize first row with base case values
        for (int j = 0; j <= n; j++) {
            previousRow[j] = j;
        }

        // Compute remaining matrix values
        for (int i = 1; i <= m; i++) {
            // Initialize first column with row value
            currentRow[0] = i;

            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) currentRow[j] = previousRow[j - 1]; // Equal
                else currentRow[j] = 1 + Math.min(previousRow[j - 1], Math.min(previousRow[j], currentRow[j - 1]));
            }

            previousRow = Arrays.copyOf(currentRow, currentRow.length);
        }

        return previousRow[n];
    }
}
