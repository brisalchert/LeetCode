//----------------------------------------------------------------------------------------------------------------------
//  67. Add Binary
//
//  Given two binary strings a and b, return their sum as a binary string.
//
//  Example 1:
//    Input: a = "11", b = "1"
//    Output: "100"
//----------------------------------------------------------------------------------------------------------------------

package Problem67;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }

            sb.append(carry % 2);
            carry /= 2;
        }

        return sb.reverse().toString();
    }
}
