//----------------------------------------------------------------------------------------------------------------------
//  14. Longest Common Prefix
//
//  Write a function to find the longest common prefix string amongst an array of strings.
//
//  If there is no common prefix, return an empty string "".
//----------------------------------------------------------------------------------------------------------------------

package Problem14;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower", "flow", "flight"};

        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix;

        // Store the first string as the prefix
        prefix = strs[0];

        // Compare first string against the remaining elements
        for (int index = 1; index < strs.length; index++) {
            int strIndex = 0;

            // Check each character for a match before incrementing the index
            while ((strIndex < strs[index].length()) &&
                    (strIndex < prefix.length()) &&
                    (prefix.charAt(strIndex) == strs[index].charAt(strIndex))) {
                strIndex++;
            }

            // Return early if there is no common prefix, else set the prefix and continue
            if (strIndex == 0) {
                return "";
            }
            else {
                prefix = prefix.substring(0, strIndex);
            }
        }

        return prefix;
    }
}
