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
        return 0;
    }
}
