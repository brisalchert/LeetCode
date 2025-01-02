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
        double x = 2.0;
        int n = 10;

        System.out.println(myPow(x, n));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        return 0;
    }
}
