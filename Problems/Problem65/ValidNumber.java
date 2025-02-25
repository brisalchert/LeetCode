//----------------------------------------------------------------------------------------------------------------------
//  65. Valid Number
//
//  Given a string s, return whether s is a valid number.
//
//  For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
//  "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3",
//  "99e2.5", "--6", "-+3", "95a54e53".
//
//  Formally, a valid number is defined using one of the following definitions:
//
//  1. An integer number followed by an optional exponent.
//  2. A decimal number followed by an optional exponent.
//
//  An integer number is defined with an optional sign '-' or '+' followed by digits.
//
//  A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:
//
//  1. Digits followed by a dot '.'.
//  2. Digits followed by a dot '.' followed by digits.
//  3. A dot '.' followed by digits.
//
//  An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.
//
//  The digits are defined as one or more digits.
//
//  Example 1:
//    Input: s = "0"
//    Output: true
//
//  Example 2:
//    Input: s = "e"
//    Output: false
//----------------------------------------------------------------------------------------------------------------------

package Problem65;

public class ValidNumber {
    public static void main(String[] args) {
        String s = "-90E3";

        System.out.println(isNumber(s));
    }

    public static boolean isNumber(String s) {
        boolean decimalSeen = false;
        boolean exponentSeen = false;
        boolean digitSeen = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9') digitSeen = true;
            else if (c == '.') {
                if (exponentSeen || decimalSeen) return false;
                decimalSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (exponentSeen || !digitSeen) return false;
                digitSeen = false;
                exponentSeen = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') return false;
            } else return false;
        }

        // Ensure number does not end with an empty exponent
        return digitSeen;
    }
}
