//----------------------------------------------------------------------------------------------------------------------
//  50. Pow(x, n)
//
//  Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
//
//  Example 1:
//    Input: x = 2.00000, n = 10
//    Output: 1024.00000
//----------------------------------------------------------------------------------------------------------------------

package Problem50;

public class Pow {
    public static void main(String[] args) {
        double x = 1.000000001;
        int n = 2147483647;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        long exp = n;

        if (exp == 0) {
            return 1;
        }

        double result = 1.0;

        // Handle negative exponent
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }

        // Calculate result with binary exponentiation
        while (exp > 0) {
            // If n is odd, multiply once so n is now even
            if (exp % 2 == 1) {
                result *= x;
            }

            // x^n == (x^2)^(n/2)
            x *= x;
            exp /= 2;
        }

        return result;
    }
}
