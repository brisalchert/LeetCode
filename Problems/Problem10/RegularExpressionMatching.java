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
    static Boolean[][] memoTable;

    public static void main(String[] args) {
        String expression = "ab";
        String pattern = "a*b";

        System.out.println(isMatch(expression, pattern));
    }

    /**
     * Checks if an expression String matches a pattern regular expression String
     * @param expression the expression String
     * @param pattern the pattern String
     * @return true if the expression matches the pattern, false otherwise
     */
    public static boolean isMatch(String expression, String pattern) {
        // Create memoization table for matches
        memoTable = new Boolean[expression.length() + 1][pattern.length() + 1];

        // Use Dynamic Programming to solve sub-problems
        return checkMatchDP(0, 0, expression, pattern);
    }

    /**
     * Checks recursively (using DP) whether the characters in the expression match the pattern
     * @param expressionIndex index in the expression
     * @param patternIndex index in the pattern
     * @param expression the expression String
     * @param pattern the pattern String
     * @return true if the expression matches the pattern, false otherwise
     */
    public static boolean checkMatchDP(int expressionIndex, int patternIndex, String expression, String pattern) {
        // Check if memoization table has the result already
        if (memoTable[expressionIndex][patternIndex] != null) {
            return memoTable[expressionIndex][patternIndex];
        }

        boolean result;

        // If pattern is exhausted, then expression is valid if also exhausted
        if (patternIndex == pattern.length()) {
            result = (expressionIndex == expression.length());
        }
        else {
            // Check if current characters match or pattern contains wildcard
            boolean currentMatch = (expressionIndex < expression.length() &&
                                        (pattern.charAt(patternIndex) == expression.charAt(expressionIndex) ||
                                         pattern.charAt(patternIndex) == '.'));

            // If pattern has a '*' at next character, check if 0 instances of current character (skip 2 in pattern)
            // or 1 or more instances (check current characters and next in expression)
            if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
                result = (checkMatchDP(expressionIndex, (patternIndex + 2), expression, pattern) ||
                          currentMatch && checkMatchDP((expressionIndex + 1), patternIndex, expression, pattern));
            }
            else {
                // If no '*' at next character, check next match in expression and pattern
                result = currentMatch && checkMatchDP((expressionIndex + 1), (patternIndex + 1), expression, pattern);
            }
        }

        // Set the current location in memoTable to the result
        memoTable[expressionIndex][patternIndex] = result;
        return result;
    }
}
