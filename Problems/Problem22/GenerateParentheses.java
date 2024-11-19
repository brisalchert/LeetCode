//----------------------------------------------------------------------------------------------------------------------
//  22. Generate Parentheses
//
//  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//  Example 1:
//    Input: n = 3
//    Output: ["((()))","(()())","(())()","()(())","()()()"]
//
//  Example 2:
//    Input: n = 1
//    Output: ["()"]
//----------------------------------------------------------------------------------------------------------------------

package Problem22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(generateParenthesis(n));
    }

    public static List<String> generateParenthesis(int n) {
        // Initialize result list
        List<String> result = new ArrayList<>();

        // Call the recursive helper method
        parenthesisHelper(n, result, "", 0, 0);

        return result;
    }

    /**
     * Similar to a binary tree traversal, the algorithm checks both possible paths (adding an open or closed
     * parenthesis) for each current string value. The result list is built from the leaf nodes.
     * @param n the maximum number of open or closed parentheses
     * @param result the result list
     * @param string the current string
     * @param num_open the number of open parentheses in the current string
     * @param num_closed the number of closed parentheses in the current string
     */
    private static void parenthesisHelper(int n, List<String> result, String string, int num_open, int num_closed) {
        // Base case: append the string if it is complete
        if (string.length() == 2 * n) {
            result.add(string);

            return;
        }

        // Try to add an open parenthesis and call recursively
        if (num_open < n) {
            parenthesisHelper(n, result, string + "(", num_open + 1, num_closed);
        }

        // Try to add a closed parenthesis and call recursively
        if (num_closed < num_open) {
            parenthesisHelper(n, result, string + ")", num_open, num_closed + 1);
        }
    }
}
