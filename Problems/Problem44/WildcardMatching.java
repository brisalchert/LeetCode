//----------------------------------------------------------------------------------------------------------------------
//  44. Wildcard Matching
//
//  Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?'
//  and '*' where:
//
//  - '?' Matches any single character.
//  - '*' Matches any sequence of characters (including the empty sequence).
//
//  The matching should cover the entire input string (not partial).
//
//  Example 1:
//    Input: s = "aa", p = "*"
//    Output: true
//    Explanation: '*' matches any sequence.
//----------------------------------------------------------------------------------------------------------------------

package Problem44;

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "ab";
        String p = "*";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        return false;
    }
}
