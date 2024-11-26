//----------------------------------------------------------------------------------------------------------------------
//  29. Divide Two Integers
//
//  Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod
//  operator.
//
//  The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345
//  would be truncated to 8, and -2.7335 would be truncated to -2.
//
//  Return the quotient after dividing dividend by divisor.
//
//  Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer
//  range: [−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1,
//  and if the quotient is strictly less than -2^31, then return -2^31.
//----------------------------------------------------------------------------------------------------------------------

package Problem29;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;

        System.out.println(divide(dividend, divisor));
    }

    public static int divide(int dividend, int divisor) {
        // Check case for out of bounds quotient
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Base cases:
        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            return -dividend;
        }

        // Determine whether to add or subtract divisor based on signs
        boolean oppositeSign = (dividend < 0) ^ (divisor < 0);

        // Get the absolute value of both dividend and divisor
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Get quotient by continually finding the largest power of 2 that the dividend is greater or equal to
        while (absDividend >= absDivisor) {
            // Set variables for the largest divisor and its multiplier
            long currentDivisor = absDivisor;
            int mutliplier = 1;

            // Increase the power of the divisor and multiplier to find the largest possible multiple
            while (absDividend >= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                mutliplier <<= 1;
            }

            // Subtract the divisor from the dividend and add the multiplier to the quotient
            absDividend -= currentDivisor;
            quotient += mutliplier;
        }

        // Swap the sign of the result if necessary
        return (oppositeSign ? -quotient : quotient);
    }
}
