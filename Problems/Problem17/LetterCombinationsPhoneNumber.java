//----------------------------------------------------------------------------------------------------------------------
//  17. Letter Combinations of a Phone Number
//
//  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
//  represent. Return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Problem17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String digits = "79";

        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // If digits is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // Create a map of digits to their possible letters
        Map<Character, String> letterMap = getLetterMap();

        // Call the recursive helper method
        letterCombinationHelper(digits, 0, "", result, letterMap);

        return result;
    }

    private static void letterCombinationHelper(String digits, int digitIndex,
                                                String combination, List<String> result,
                                                Map<Character, String> letterMap) {
        // Base case: return when a combination is finished, adding it to result
        if (digitIndex == digits.length()) {
            result.add(combination);

            return;
        }

        // Recursive case: add each possible letter for the current digit and continue recursively
        // for each combination
        String possibleLetters = letterMap.get(digits.charAt(digitIndex));

        for (int i = 0; i < possibleLetters.length(); i++) {
            // Add the current possible letter to the combination
            combination += possibleLetters.charAt(i);

            // Call recursively
            letterCombinationHelper(digits, digitIndex + 1, combination, result, letterMap);

            // Remove the last letter from the combination
            combination = combination.substring(0, combination.length() - 1);
        }
    }

    public static Map<Character, String> getLetterMap() {
        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        return map;
    }
}
