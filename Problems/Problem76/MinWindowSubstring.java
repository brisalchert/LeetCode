//----------------------------------------------------------------------------------------------------------------------
//  76. Minimum Window Substring
//
//  Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that
//  every character in t (including duplicates) is included in the window. If there is no such substring, return
//  the empty string "".
//
//  The testcases will be generated such that the answer is unique.
//
//  Example 1:
//    Input: s = "ADOBECODEBANC", t = "ABC"
//    Output: "BANC"
//    Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
//----------------------------------------------------------------------------------------------------------------------

package Problem76;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        return "";
    }
}
