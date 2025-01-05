//----------------------------------------------------------------------------------------------------------------------
//  2381. Shifting Letters II
//
//  You are given a string s of lowercase English letters and a 2D integer array shifts where
//  shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index
//  endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.
//
//  Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z'
//  becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet
//  (wrapping around so that 'a' becomes 'z').
//
//  Return the final string after all such shifts to s are applied.
//
//  Example 1:
//    Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
//    Output: "ace"
//    Explanation: Firstly, shift the characters from index 0 to index 1 backward. Now s = "zac".
//    Secondly, shift the characters from index 1 to index 2 forward. Now s = "zbd".
//    Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
//----------------------------------------------------------------------------------------------------------------------

package Problem2381;

public class ShiftingLetters2 {
    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1}
        };

        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        return null;
    }
}
