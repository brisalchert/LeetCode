//----------------------------------------------------------------------------------------------------------------------
//  1408. String Matching in an Array
//
//  Given an array of string words, return all strings in words that is a substring of another word. You can return
//  the answer in any order.
//
//  A substring is a contiguous sequence of characters within a string
//
//  Example 1:
//
//    Input: words = ["mass","as","hero","superhero"]
//    Output: ["as","hero"]
//    Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
//    ["hero","as"] is also a valid answer.
//----------------------------------------------------------------------------------------------------------------------

package Problem1408;

import java.util.*;

public class StringMatchingInArray {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "heroes", "superhero"};

        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static List<String> stringMatchingKMP(String[] words) {
        // Sort by length in ascending order
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (search(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    private static void constructLPS(String pat, int[] lps) {
        int len = 0;
        lps[0] = 0;

        int i = 1;

        while (i < pat.length()) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    private static boolean search(String pat, String word) {
        int n = word.length();
        int m = pat.length();

        int[] lps = new int[m];
        constructLPS(pat, lps);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (word.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }
}
