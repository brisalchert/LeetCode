//----------------------------------------------------------------------------------------------------------------------
//  69. Sqrt(x)
//
//  Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned
//  integer should be non-negative as well.
//
//  You must not use any built-in exponent function or operator.
//
//  - For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//
//  Example 1:
//    Input: x = 8
//    Output: 2
//    Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
//----------------------------------------------------------------------------------------------------------------------

package Problem69;

public class SqrtX {
    public static void main(String[] args) {
        int x = 144;

        System.out.println(mySqrt(x));
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int n = 3;
        int result = 0;

        while (x > 0) {
            x -= n;
            n += 2;
            result++;
        }

        return result;
    }
}
