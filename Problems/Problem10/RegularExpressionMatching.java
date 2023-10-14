//----------------------------------------------------------------------------------------------------------------------
//  10. Regular Expression Matching
//
//  Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//    '.' Matches any single character.
//    '*' Matches zero or more of the preceding element.
//
//  The matching should cover the entire input string (not partial).
//----------------------------------------------------------------------------------------------------------------------

package Problem10;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        String expression = "aa";
        String pattern = "aa";

        System.out.println(expressionMatches(expression, pattern));
    }

    public static boolean expressionMatches(String expression, String pattern) {
        // Case for special characters in pattern
        if (pattern.contains("*") || pattern.contains(".")) {

        }
        else {
            // Trivial case for no special characters in pattern
            if (!expression.equals(pattern)) {
                return false;
            }
        }

        return true;
    }
}
