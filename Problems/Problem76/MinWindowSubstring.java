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
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) return "";

        // Map for ASCII character indices
        int[] charMap = new int[128];
        int count = t.length();
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, resultIndex = 0;

        // Add character counts in t to charMap
        for (char c : t.toCharArray()) {
            charMap[c]++;
        }

        while (right < s.length()) {
            char c = s.charAt(right);

            // Decrement the count if the character is necessary for the substring
            if (charMap[c] > 0) {
                count--;
            }

            charMap[c]--;

            // Check length of valid substrings
            while (count == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    resultIndex = left;
                }

                // Add character back to map if it is part of t
                if (charMap[s.charAt(left)] == 0) {
                    count++;
                }

                charMap[s.charAt(left)]++;
                left++;
            }

            right++;
        }

        // Return an empty string if no valid substring was found
        return (minLength == Integer.MAX_VALUE) ? "" : s.substring(resultIndex, resultIndex + minLength);
    }
}
