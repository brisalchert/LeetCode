//----------------------------------------------------------------------------------------------------------------------
//  3. Longest Substring Without Repeating Characters
//
//  Given a string s, find the length of the longest substring without repeating characters.
//----------------------------------------------------------------------------------------------------------------------

package Problem3;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String input = "abcdefg";

        System.out.println(longestSubstring(input));
    }

    /**
     * Finds the length of the longest substring without repeating characters
     * @param input the input string
     * @return the integer length of the longest substring without repeating characters
     */
    public static int longestSubstring(String input) {
        // Create a HashSet for storing the non-repeating characters
        HashSet<Character> charSet = new HashSet<>();
        int maxLength = 0;
        int leftIndex = 0;

        for (int rightIndex = 0; rightIndex < input.length(); rightIndex++) {
            // Try to add the current character to the set
            while(!charSet.add(input.charAt(rightIndex))) {
                // If it cannot be added, remove characters from the left until the duplicate is removed
                charSet.remove(input.charAt(leftIndex));
                leftIndex++;
            }

            // Recalculate maxLength
            maxLength = Math.max(maxLength, (rightIndex - leftIndex + 1));
        }

        return maxLength;
    }
}
