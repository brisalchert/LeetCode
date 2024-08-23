//----------------------------------------------------------------------------------------------------------------------
//  17. Letter Combinations of a Phone Number
//
//  Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could
//  represent. Return the answer in any order.
//----------------------------------------------------------------------------------------------------------------------

package Problem17;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        String digits = "79";

        long start = System.nanoTime();
        System.out.println(letterCombinations(digits));
        long end = System.nanoTime();

        System.out.println((end - start) / 1000000 + " ms");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        // If digits is empty, return an empty list
        if (digits.isEmpty()) {
            return result;
        }

        // Create an array of possible letters for the different digits
        String[] letterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        // Call the recursive helper method
        letterCombinationHelper(new StringBuilder(), digits, letterMap, result);

        return result;
    }

    private static void letterCombinationHelper(StringBuilder combination, String remainingDigits,
                                                String[] letterMap, List<String> result) {
        // Base case: return when a combination is finished, adding it to result
        if (remainingDigits.isEmpty()) {
            result.add(combination.toString());

            return;
        }

        // Recursive case: add each possible letter for the current digit and continue recursively
        String possibleLetters = letterMap[remainingDigits.charAt(0) - '2'];

        for (char letter : possibleLetters.toCharArray()) {
            // Append the possible letter to the combination
            combination.append(letter);

            // Call recursively, sub-setting the remaining digits
            letterCombinationHelper(combination, remainingDigits.substring(1),
                                    letterMap, result);

            // Remove the added letter from the combination
            combination.deleteCharAt(combination.length() - 1);
        }
    }
}
