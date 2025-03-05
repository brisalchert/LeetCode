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

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int previous;
        int[] currentRow = new int[n + 1];

        // Initialize first row with base case values
        for (int j = 0; j <= n; j++) {
            currentRow[j] = j;
        }

        // Compute remaining matrix values
        for (int i = 1; i <= m; i++) {
            // Initialize first column with row value
            previous = currentRow[0];
            currentRow[0] = i;

            for (int j = 1; j <= n; j++) {
                int temp = currentRow[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) currentRow[j] = previous; // Equal
                else currentRow[j] = 1 + Math.min(previous, Math.min(currentRow[j], currentRow[j - 1]));

                previous = temp; // Save diagonal value from previous row
            }
        }

        return currentRow[n];
    }
}
