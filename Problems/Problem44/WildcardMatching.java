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
        String s = "abcabczzzde";
        String p = "*abc???de*";

        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int sIndex = 0;
        int pIndex = 0;
        int starIndex = -1;
        int seqStarIndex = 0;

        while (sIndex < s.length()) {
            // If characters match or ? encountered, advance both pointers
            if (pIndex < p.length() && (p.charAt(pIndex) == s.charAt(sIndex) || p.charAt(pIndex) == '?')) {
                sIndex++;
                pIndex++;
            }
            // If * encountered, advance only pIndex
            else if (pIndex < p.length() && (p.charAt(pIndex) == '*')) {
                starIndex = pIndex;
                seqStarIndex = sIndex;
                pIndex++;
            }
            // If not matching but * previously encountered, return to * and skip a character
            else if (starIndex != -1) {
                pIndex = starIndex + 1;
                seqStarIndex++;
                sIndex = seqStarIndex;
            }
            // If not matching and no * encountered, return false
            else return false;
        }

        // Remove remaining * in pattern
        while (pIndex < p.length() && p.charAt(pIndex) == '*') {
            pIndex++;
        }

        return pIndex == p.length();
    }
}
