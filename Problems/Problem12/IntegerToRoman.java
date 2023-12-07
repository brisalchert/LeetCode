//----------------------------------------------------------------------------------------------------------------------
//  12. Integer to Roman
//
//  Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//  Symbol       Value
//  I             1
//  V             5
//  X             10
//  L             50
//  C             100
//  D             500
//  M             1000
//
//  For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is
//  simply X + II. The number 27 is written as XXVII, which is XX + V + II.
//
//  Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
//  IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
//  The same principle applies to the number nine, which is written as IX. There are six instances where subtraction
//  is used:
//
//  I can be placed before V (5) and X (10) to make 4 and 9.
//  X can be placed before L (50) and C (100) to make 40 and 90.
//  C can be placed before D (500) and M (1000) to make 400 and 900.
//
//  Given an integer, convert it to a roman numeral.
//----------------------------------------------------------------------------------------------------------------------

package Problem12;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 58;

        System.out.println(intToRoman(num));
    }

    /**
     * Converts an Integer between 1 and 3999 to a Roman Numeral
     * @param num the Integer to convert
     * @return the Integer as a Roman Numeral
     */
    public static String intToRoman(int num) {
        int modulus = 10;
        StringBuilder numeralBuilder = new StringBuilder();
        Stack<String> numeralStack = new Stack<>();
        Map<Integer, String> numeralMap = initializeNumeralMap();

        while (num > 0) {
            // Get the next smallest value to convert to Roman
            int currentNumeral = num % modulus;

            // Subtract the value of currentNumeral from num for next iteration
            num -= currentNumeral;

            if (currentNumeral > 0) {
                // Convert currentNumeral to Roman
                if (numeralMap.containsKey(currentNumeral)) {
                    numeralStack.push(numeralMap.get(currentNumeral));
                }
                else {
                    // Set a power of ten for the current digit
                    int digit = modulus / 10;
                    StringBuilder currentNumeralBuilder = new StringBuilder();

                    while (currentNumeral > 0) {
                        // Check if the numeral's largest digit is greater than 5
                        if (currentNumeral > (digit * 5)) {
                            currentNumeralBuilder.append(numeralMap.get(digit * 5));
                            currentNumeral -= (digit * 5);
                        }
                        else {
                            currentNumeralBuilder.append(numeralMap.get(digit));
                            currentNumeral -= digit;
                        }
                    }

                    numeralStack.push(currentNumeralBuilder.toString());
                }
            }

            // Increment the modulus for the next digit
            modulus *= 10;
        }

        // Get the finished numeral from the stack
        while (!numeralStack.isEmpty()) {
            numeralBuilder.append(numeralStack.pop());
        }

        return numeralBuilder.toString();
    }

    /**
     * Initializes a Map of Integer keys to Roman Numeral values
     * @return the numeralMap
     */
    private static Map<Integer, String> initializeNumeralMap() {
        Map<Integer, String> numeralMap = new HashMap<>();

        // Initialize numeralMap
        numeralMap.put(1, "I");
        numeralMap.put(4, "IV");
        numeralMap.put(5, "V");
        numeralMap.put(9, "IX");
        numeralMap.put(10, "X");
        numeralMap.put(40, "XL");
        numeralMap.put(50, "L");
        numeralMap.put(90, "XC");
        numeralMap.put(100, "C");
        numeralMap.put(400, "CD");
        numeralMap.put(500, "D");
        numeralMap.put(900, "CM");
        numeralMap.put(1000, "M");

        return numeralMap;
    }
}
