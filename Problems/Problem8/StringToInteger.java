//----------------------------------------------------------------------------------------------------------------------
//  8. String to Integer (atoi)
//
//  Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s
//  atoi function).
//
//  The algorithm for myAtoi(string s) is as follows:
//
//  1. Read in and ignore any leading whitespace.
//  2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if
//     it is either. This determines if the final result is negative or positive respectively. Assume the result is
//     positive if neither is present.
//  3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of
//     the string is ignored.
//  4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer
//     is 0. Change the sign as necessary (from step 2).
//  5. If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it
//     remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater
//     than 231 - 1 should be clamped to 231 - 1.
//  6. Return the integer as the final result.
//
//  Note:
//  - Only the space character ' ' is considered a whitespace character.
//  - Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.
//----------------------------------------------------------------------------------------------------------------------

package Problem8;

import java.util.Scanner;

public class StringToInteger {
    public static void main(String[] args) {
        String input = "+1";

        System.out.println(myAtoi(input));
    }

    /**
     * Retrieves the first integer within a string excluding initial whitespace and characters after the integer.
     * If the integer falls out of the maximum integer value range, it is clamped to the nearest bound
     * @param s the input string
     * @return the integer within the string
     */
    public static int myAtoi(String s) {
        // Trivial case for empty String
        if (s.length() == 0) {
            return 0;
        }

        int index = 0;
        char currentCharacter;
        boolean isNegative;
        final int MAX_LIMIT = Integer.MAX_VALUE / 10;
        int result = 0;

        // Skip whitespace
        while ((index < s.length()) && (s.charAt(index) == ' ')) {
            index++;
        }

        if (index == s.length()) {
            return 0;
        }

        // Check if the final value should be negative
        currentCharacter = s.charAt(index);
        isNegative = (currentCharacter == '-');

        if (isNegative || (currentCharacter == '+')) {
            index++;
        }

        // Convert the string to an integer one character at a time
        while ((index < s.length()) && Character.isDigit(currentCharacter = s.charAt(index))) {
            int digit = currentCharacter - '0';  // Converts ASCII to digit

            // Check if the result is too large
            if (result > ((Integer.MAX_VALUE - digit) / 10)) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                }
                else {
                    return Integer.MAX_VALUE;
                }
            }

            result *= 10;
            result += digit;

            index++;
        }

        // Return the result with the correct sign
        if (isNegative) {
            return -result;
        }
        else {
            return result;
        }
    }
}
