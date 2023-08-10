//----------------------------------------------------------------------------------------------------------------------
//  7. Reverse Integer
//
//  Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside
//  the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.
//
//  Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//----------------------------------------------------------------------------------------------------------------------

package Problem7;

public class ReverseInteger {
    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        // Trivial case for single-digit integer
        if ((x / 10) == 0) {
            return x;
        }

        // Add main algorithm here

        return x;
    }
}
