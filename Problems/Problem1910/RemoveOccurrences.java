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

import java.util.Stack;

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

        int sIndex = 0;
        int pIndex = 0;
        Stack<Integer> pIndexStack = new Stack<>();

        while (sIndex < s.length()) {
            if (s.charAt(sIndex) == part.charAt(pIndex)) {
                pIndex++;
                pIndexStack.push(pIndex);

                if (pIndex == part.length()) {
                    // Remove substring
                    s = s.substring(0, sIndex - part.length() + 1) + s.substring(sIndex + 1);
                    for (int i = 0; i < part.length(); i++) {
                        pIndexStack.pop();
                    }

                    // Reset indices
                    sIndex -= part.length();
                    pIndex = (pIndexStack.isEmpty()) ? 0 : pIndexStack.peek();
                }

                sIndex++;
            } else if (pIndex > 0) {
                pIndex--;
            } else {
                pIndexStack.clear();

                sIndex++;
            }
        }

        return s;
    }
}
