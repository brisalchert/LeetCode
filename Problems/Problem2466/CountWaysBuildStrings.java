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

import java.util.Arrays;

public class CountWaysBuildStrings {
    public static void main(String[] args) {
        int low = 200, high = 200, zero = 10, one = 1;

        System.out.println(countGoodStrings(low, high, zero, one));
    }

    public static int countGoodStrings(int low, int high, int zero, int one) {
        long result = 0;

        // Get counts of all lengths from low to high (inclusive)
        int[] counts = new int[high + 1];
        Arrays.fill(counts, -1);
        for (int i = low; i <= high; i++) {
            result += count(i, counts, zero, one);
        }

        return (int) (result % (1e9 + 7));
    }

    private static int count(int n, int[] counts, int zero, int one) {
        if (n == 0) {
            return 0;
        }

        if (counts[n] != -1) {
            return counts[n];
        }

        long count = 0;

        if (n == zero) {
            count += 1;
        }

        if (n == one) {
            count += 1;
        }

        if (n > zero) {
            count += count(n - zero, counts, zero, one);
        }

        if (n > one) {
            count += count(n - one, counts, zero, one);
        }

        counts[n] = (int) (count % (1e9 + 7));

        return counts[n];
    }
}
