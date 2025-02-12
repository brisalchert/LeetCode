//----------------------------------------------------------------------------------------------------------------------
//  1910. Remove All Occurrences of a Substring
//
//  Given two strings s and part, perform the following operation on s until all occurrences of the substring part
//  are removed:
//
//  - Find the leftmost occurrence of the substring part and remove it from s.
//
//  Return s after removing all occurrences of part.
//
//  A substring is a contiguous sequence of characters in a string.
//
//  Example 1:
//    Input: s = "daabcbaabcbc", part = "abc"
//    Output: "dab"
//    Explanation: The following operations are done:
//    - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
//    - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
//    - s = "dababc", remove "abc" starting at index 3, so s = "dab".
//    Now s has no occurrences of "abc".
//----------------------------------------------------------------------------------------------------------------------

package Problem1910;

public class RemoveOccurrences {
    public static void main(String[] args) {
        String s = "axxxxyyyyb";
        String part = "xy";

        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {
        if (s.length() < part.length()) {
            return s;
        }

        char[] sArray = s.toCharArray();
        char[] partArray = part.toCharArray();
        char[] resultStack = new char[sArray.length];
        int stackSize = 0;
        char partEndChar = partArray[partArray.length - 1];

        for (char c : sArray) {
            resultStack[stackSize++] = c;

            // Check for possibility of instance of part
            if (c == partEndChar && stackSize >= partArray.length) {
                int i = stackSize - 1;
                int j = partArray.length - 1;

                // Check if the entirety of part is present
                while (j >= 0 && resultStack[i] == partArray[j]) {
                    i--;
                    j--;
                }

                // If entire part was found, move stack size/index back to overwrite part
                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }

        return new String(resultStack, 0, stackSize);
    }
}
