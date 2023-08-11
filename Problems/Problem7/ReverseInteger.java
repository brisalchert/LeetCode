//----------------------------------------------------------------------------------------------------------------------
//  7. Reverse Integer
//
//  Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
//  the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
//
//  Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//----------------------------------------------------------------------------------------------------------------------

package Problem7;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseInteger {
    public static void main(String[] args) {
        int input = 1234;

        System.out.println(reverse(input));
    }

    /**
     * Reverses and returns the input integer, or returns 0 if the reversed integer is too large (positive or negative)
     * @param x the input integer
     * @return the reversed integer
     */
    public static int reverse(int x) {
        // Trivial case for single-digit integer
        if ((x / 10) == 0) {
            return x;
        }

        Queue<Integer> digitQueue = new LinkedList<>();
        int result = 0;

        // Place each digit onto the Stack
        while (Math.abs(x) > 0) {
            digitQueue.add(x % 10);
            x /= 10;
        }

        // Take each digit off the stack and store in the result
        while (!digitQueue.isEmpty()) {
            result += digitQueue.poll();

            // Check if there is a next digit
            if (!digitQueue.isEmpty()) {
                // Check if result will be too large (positive or negative)
                if ((result > (Integer.MAX_VALUE / 10)) || (result < (Integer.MIN_VALUE / 10))) {
                    return 0;
                }
                else {
                    result *= 10;
                }
            }
        }

        return result;
    }
}
