//----------------------------------------------------------------------------------------------------------------------
//  28. Find the Index of the First Occurrence in a String
//
//  Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if
//  needle is not part of haystack.
//
//  Example 1:
//    Input: haystack = "sadbutsad", needle = "sad"
//    Output: 0
//    Explanation: "sad" occurs at index 0 and 6.
//    The first occurrence is at index 0, so we return 0.
//
//  Example 2:
//    Input: haystack = "leetcode", needle = "leeto"
//    Output: -1
//    Explanation: "leeto" did not occur in "leetcode", so we return -1.
//----------------------------------------------------------------------------------------------------------------------

package Problem28;

public class IndexOfFirstOccurrence {
    public static void main(String[] args) {
        String haystack = "haystack";
        String needle = "stack";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        // Iterate through the haystack String, checking for occurrences of needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            // If the substring from the current index is needle, return the starting index
            if (needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }

        // If the needle String is not in haystack, return -1
        return -1;
    }
}
