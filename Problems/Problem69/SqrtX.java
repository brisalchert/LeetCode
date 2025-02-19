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
        int left = 1;
        int right = x;
        int mid;

        // Perform binary search for the largest integer square root that does not overshoot x
        while (left <= right) {
            mid = left + (right - left) / 2; // Avoid integer overflow

            if (mid > x / mid) {
                right = mid - 1;
            } else if (mid < x / mid) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right;
    }
}
