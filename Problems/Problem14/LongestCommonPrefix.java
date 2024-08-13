//----------------------------------------------------------------------------------------------------------------------
//  14. Longest Common Prefix
//
//  Write a function to find the longest common prefix string amongst an array of strings.
//
//  If there is no common prefix, return an empty string "".
//----------------------------------------------------------------------------------------------------------------------

package Problem14;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] strs) {
        // Sort the array so we can compare the first and last elements only
        Arrays.sort(strs);
        int index = 0;
        String first = strs[0];
        String last = strs[strs.length - 1];

        // Increment the index for the prefix as long as characters match
        while (index < first.length() && index < last.length() && first.charAt(index) == last.charAt(index)) {
            index++;
        }

        // Return the prefix
        return first.substring(0, index);
    }
}
