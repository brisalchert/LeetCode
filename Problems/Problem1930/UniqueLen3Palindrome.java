//----------------------------------------------------------------------------------------------------------------------
//  1930. Unique Length-3 Palindromic Subsequences
//
//  Given a string s, return the number of unique palindromes of length three that are a subsequence of s.
//
//  Note that even if there are multiple ways to obtain the same subsequence, it is still only counted once.
//
//  A palindrome is a string that reads the same forwards and backwards.
//
//  A subsequence of a string is a new string generated from the original string with some characters (can be none)
//  deleted without changing the relative order of the remaining characters.
//
//  - For example, "ace" is a subsequence of "abcde".
//
//  Example 1:
//    Input: s = "aabca"
//    Output: 3
//    Explanation: The 3 palindromic subsequences of length 3 are:
//    - "aba" (subsequence of "aabca")
//    - "aaa" (subsequence of "aabca")
//    - "aca" (subsequence of "aabca")
//----------------------------------------------------------------------------------------------------------------------

package Problem1930;

import java.util.HashSet;
import java.util.Set;

public class UniqueLen3Palindrome {
    public static void main(String[] args) {
        String s = "aabca";

        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet<>();

        for (char c : s.toCharArray()) {
            letters.add(c);
        }

        int result = 0;

        // Find first and last occurrence of each letter
        for (char letter : letters) {
            int i = -1;
            int j = 0;

            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }

                    j = k;
                }
            }

            // Create a set of all palindromes for the current letter
            Set<Character> uniquePalindromes = new HashSet<>();

            for (int k = i + 1; k < j; k++) {
                uniquePalindromes.add(s.charAt(k));
            }

            result += uniquePalindromes.size();
        }

        return result;
    }
}
