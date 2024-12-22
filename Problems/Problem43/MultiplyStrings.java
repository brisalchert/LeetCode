//----------------------------------------------------------------------------------------------------------------------
//  43. Multiply Strings
//
//  Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2,
//  also represented as a string.
//
//  Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
//
//  Example 1:
//    Input: num1 = "2", num2 = "3"
//    Output: "6"
//----------------------------------------------------------------------------------------------------------------------

package Problem43;

public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "2345", num2 = "99";

        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int[] resultDigits = new int[num1.length() + num2.length()];

        // Multiply each digit in num1 by each digit in num2
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int tensIndex = i + j, onesIndex = i + j + 1;

                // Carry previous digit
                int sum = multi + resultDigits[onesIndex];

                resultDigits[tensIndex] += sum / 10;
                resultDigits[onesIndex] = sum % 10;
            }
        }

        // Convert digits to string
        StringBuilder sb = new StringBuilder();

        for (int digit : resultDigits) {
            // Don't add leading zeroes
            if (!(sb.isEmpty() && digit == 0)) {
                sb.append(digit);
            }
        }

        return sb.isEmpty() ? "0" : sb.toString();
    }
}
