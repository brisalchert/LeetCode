//----------------------------------------------------------------------------------------------------------------------
//  2466. Count Ways To Build Good Strings
//
//  Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then
//  at each step perform either of the following:
//
//  - Append the character '0' zero times.
//  - Append the character '1' one times.
//
//  This can be performed any number of times.
//
//  A good string is a string constructed by the above process having a length between low and high (inclusive).
//
//  Return the number of different good strings that can be constructed satisfying these properties. Since the answer
//  can be large, return it modulo 10^9 + 7.
//
//  Example 1:
//    Input: low = 3, high = 3, zero = 1, one = 1
//    Output: 8
//    Explanation:
//    One possible valid good string is "011".
//    It can be constructed as follows: "" -> "0" -> "01" -> "011".
//    All binary strings from "000" to "111" are good strings in this example.
//----------------------------------------------------------------------------------------------------------------------

package Problem2466;

public class CountWaysBuildStrings {
    public static void main(String[] args) {
        int low = 3, high = 8, zero = 2, one = 3;

        System.out.println(countGoodStrings(low, high, zero, one));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        // Ensure zero <= one (because of order of if statements)
        if (zero > one) {
            return countGoodStrings(low, high, one, zero);
        }

        int mod = (int) (1e9 + 7);

        int[] counts = new int[high + 1];
        counts[0] = 1;
        int result = 0;

        for (int n = 1; n <= high; n++) {
            // Check if adding "zero" characters is valid
            if (n >= zero) {
                counts[n] = (counts[n] + counts[n - zero]) % mod;
            }

            // Check if adding "one" characters is valid
            if (n >= one) {
                counts[n] = (counts[n] + counts[n - one]) % mod;
            }

            // Add all counts from low - high (inclusive) to result
            if (n >= low) {
                result = (result + counts[n]) % mod;
            }
        }

        return result;
    }
}
