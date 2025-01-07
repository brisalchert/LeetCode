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

import java.util.List;

public class StringMatchingInArray {
    public static void main(String[] args) {
        String[] words = {"mass", "as", "hero", "superhero"};

        System.out.println(stringMatching(words));
    }

    public static List<String> stringMatching(String[] words) {
        return null;
    }
}
