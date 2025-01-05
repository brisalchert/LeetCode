//----------------------------------------------------------------------------------------------------------------------
//  58. Length of Last Word
//
//  Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//  A word is a maximal substring consisting of non-space characters only.
//
//  Example 1:
//    Input: s = "Hello World"
//    Output: 5
//    Explanation: The last word is "World" with length 5.
//----------------------------------------------------------------------------------------------------------------------

package Problem58;

public class LengthLastWord {
    public static void main(String[] args) {
        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        int right;
        int left = s.length() - 1;

        // Find last non-space character
        while (s.charAt(left) == ' ') {
            left--;
        }

        // Set right pointer
        right = left;

        // Find beginning of current word
        while (left > 0 && s.charAt(left - 1) != ' ') {
            left--;
        }

        return right - left + 1;
    }
}
