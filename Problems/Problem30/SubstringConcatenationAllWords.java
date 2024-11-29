//----------------------------------------------------------------------------------------------------------------------
//  30. Substring with Concatenation of All Words
//
//  You are given a string s and an array of strings words. All the strings of words are of the same length.
//
//  A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
//
//  For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are
//  all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any
//  permutation of words.
//
//  Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in
//  any order.
//
//  Example 1:
//    Input: s = "barfoothefoobarman", words = ["foo","bar"]
//    Output: [0,9]
//    Explanation:
//    The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
//    The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
//----------------------------------------------------------------------------------------------------------------------

package Problem30;

import java.util.List;

public class SubstringConcatenationAllWords {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        return null;
    }
}
