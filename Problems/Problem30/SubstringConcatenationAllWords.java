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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationAllWords {
    public static void main(String[] args) {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar","foo","the"};

        System.out.println(findSubstring(s, words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<>();

        // Initialize an index for the current position in the string
        int outerIndex = 0;

        // Initialize integers for substring length and word length
        int substringLength = words.length;
        int wordLength = words[0].length();

        // Initialize a HashMap for frequencies of words in the array
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Check each possible starting window position for words of length wordLength
        for (int i = 0; i < wordLength; i++) {
            // Initialize a HashMap for word counts and an integer for total count
            HashMap<String, Integer> tempMap = new HashMap<>();
            int totalCount = 0;

            // Use sliding window to check for valid substrings
            for (int wordIndex = i, windowIndex = i; wordIndex + wordLength <= s.length(); wordIndex += wordLength) {
                // Get the current word
                String currentWord = s.substring(wordIndex, wordIndex + wordLength);

                // Add the current word to tempMap and increment the count
                tempMap.put(currentWord, tempMap.getOrDefault(currentWord, 0) + 1);
                totalCount++;

                // If the end of the window is reached, check if the substring is valid and slide the window
                if (totalCount == substringLength) {
                    // If the maps are equivalent, add the index to the result list
                    if (wordMap.equals(tempMap)) {
                        result.add(windowIndex);
                    }

                    // Remove the first word from the window to slide the window
                    String firstWord = s.substring(windowIndex, windowIndex + wordLength);
                    tempMap.computeIfPresent(firstWord, (key, value) -> (value > 1) ? value - 1 : null);

                    // Decrement the total count and slide the window
                    totalCount--;
                    windowIndex += wordLength;
                }
            }

            // If the word frequency maps are equal, add the starting index to result
            if (wordMap.equals(tempMap)) {
                result.add(outerIndex);
            }

            outerIndex++;
        }

        return result;
    }
}
