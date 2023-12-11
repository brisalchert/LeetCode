//----------------------------------------------------------------------------------------------------------------------
//  13. Roman to Integer
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
//  For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is
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
//  Given a roman numeral, convert it to an integer.
//----------------------------------------------------------------------------------------------------------------------

package Problem13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String numeral = "MCMXCIV";

        System.out.println(romanToInt(numeral));
    }

    /**
     * Converts a Roman Numeral between with a value between 1 and 3999 inclusive to an Integer
     * @param s the Roman Numeral as a String
     * @return the Integer value of the Roman Numeral
     */
    public static int romanToInt(String s) {
        int result = 0;
        int index = 0;
        Map<String, Integer> numeralMap = initializeNumeralMap();

        while (index < s.length()) {
            // Check if there is a next character
            if ((index + 1) < s.length()) {
                int currentCharValue = numeralMap.get(s.substring(index, (index + 1)));
                int nextCharValue = numeralMap.get(s.substring((index + 1), (index + 2)));

                // If the next character represents a larger value, use subtraction
                if (nextCharValue > currentCharValue) {
                    result -= numeralMap.get(s.substring(index, (index + 1)));
                }
                // Otherwise, use addition
                else {
                    result += numeralMap.get(s.substring(index, (index + 1)));
                }
            }
            // If the current character is the last, use addition
            else {
                result += numeralMap.get(s.substring(index, (index + 1)));
            }

            index++;
        }

        return result;
    }

    /**
     * Initializes a Map of Roman Numeral keys to Integer values
     * @return the numeralMap
     */
    private static Map<String, Integer> initializeNumeralMap() {
        Map<String, Integer> numeralMap = new HashMap<>();

        // Initialize numeralMap
        numeralMap.put("I", 1);
        numeralMap.put("V", 5);
        numeralMap.put("X", 10);
        numeralMap.put("L", 50);
        numeralMap.put("C", 100);
        numeralMap.put("D", 500);
        numeralMap.put("M", 1000);

        return numeralMap;
    }
}
