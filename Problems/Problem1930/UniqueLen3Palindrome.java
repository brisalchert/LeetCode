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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueLen3Palindrome {
    public static void main(String[] args) {
        String s = "aabca";

        System.out.println(countPalindromicSubsequence(s));
    }

    public static int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        int result = 0;

        // Get first and last indices of each letter of the alphabet
        for (int i = 0; i < s.length(); i++) {
            int alphaIndex = s.charAt(i) - 'a';

            if (first[alphaIndex] == -1) {
                first[alphaIndex] = i;
            }

            last[alphaIndex] = i;
        }

        // Get count of unique palindromes for each letter present in s
        for (int i = 0; i < 26; i++) {
            if (first[i] == -1) {
                continue;
            }

            Set<Character> uniquePalindromes = new HashSet<>();

            for (int j = first[i] + 1; j < last[i]; j++) {
                uniquePalindromes.add(s.charAt(j));
            }

            result += uniquePalindromes.size();
        }

        return result;
    }
}
