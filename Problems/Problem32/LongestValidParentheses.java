//----------------------------------------------------------------------------------------------------------------------
//  32. Longest Valid Parentheses
//
//  Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed)
//  parentheses substring.
//
//  Example 1:
//    Input: s = "(()"
//    Output: 2
//    Explanation: The longest valid parentheses substring is "()".
//----------------------------------------------------------------------------------------------------------------------

package Problem32;

public class LongestValidParentheses {
    public static void main(String[] args) {
        String input = "(()";

        System.out.println(longestValidParentheses(input));
    }

    public static int longestValidParentheses(String s) {
        // Add a prefix invalid character to prevent out-of-bounds check
        s = ")" + s;

        // Create an array for storing the valid substring lengths at each
        // index, with an extra index at the end for the final result
        int[] longest = new int[s.length() + 1];

        // Iterate through the string, checking for closed parentheses
        for (int i = 1; i < s.length(); i++) {
            // If a closed parenthesis can be matched with an open parenthesis before
            // the previous substring (or the previous character if there is no substring),
            // add those parentheses (2) to the substring length and include the adjacent
            // substring length from the left
            if (s.charAt(i) == ')' && s.charAt(i - longest[i - 1] - 1) == '(') {
                longest[i] = longest[i - 1] + 2 + longest[i - longest[i - 1] - 2];

                // Set the max longest if necessary
                longest[s.length()] = Math.max(longest[i], longest[s.length()]);
            }
        }

        // Return the longest valid substring length
        return longest[s.length()];
    }
}
