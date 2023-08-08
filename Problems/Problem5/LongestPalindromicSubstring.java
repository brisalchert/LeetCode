//----------------------------------------------------------------------------------------------------------------------
//  5. Longest Palindromic Substring
//
//  Given a string s, return the longest palindromic substring in s.
//----------------------------------------------------------------------------------------------------------------------

package Problem5;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "cbbd";

        System.out.println(longestPalindrome(input));
    }

    // Global Variables for finding the palindrome
    static int maxPalindromeLength = 0;
    static int palindromeStartIndex = 0;

    /**
     * Finds and returns the longest palindrome within a string
     * @param s the input string
     * @return the longest palindromic substring of s
     */
    public static String longestPalindrome(String s) {
        // Trivial case for one-character string
        if (s.length() < 2) {
            return s;
        }

        for (int index = 0; index < (s.length() - 1); index++) {
            expandPalindrome(s, index, index);
            expandPalindrome(s, index, (index + 1));
        }

        // Return the longest palindrome
        return s.substring(palindromeStartIndex, (palindromeStartIndex + maxPalindromeLength));
    }

    /**
     * Support function for expanding a palindrome around its center, a center being a particular index in a string
     * or a spot between two indices
     * @param s the input string of characters
     * @param leftIndex the starting left bound of the palindrome to expand from
     * @param rightIndex the starting right bound of the palindrome to expand from
     */
    private static void expandPalindrome(String s, int leftIndex, int rightIndex) {
        // Expand palindrome until indices are invalid or characters do not match
        while ((leftIndex >= 0) && (rightIndex < s.length()) && (s.charAt(leftIndex) == s.charAt(rightIndex))) {
            leftIndex--;
            rightIndex++;
        }

        // If the palindrome is longer than the current longest, mark its location in the string
        // Use (rightIndex - leftIndex - 1) because both indices are one unit further than the bounds of the palindrome
        if ((rightIndex - leftIndex - 1) > maxPalindromeLength) {
            maxPalindromeLength = (rightIndex - leftIndex - 1);
            palindromeStartIndex = (leftIndex + 1);
        }
    }
}
