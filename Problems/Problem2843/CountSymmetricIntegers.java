//----------------------------------------------------------------------------------------------------------------------
//  2843. Count Symmetric Integers
//
//  You are given two positive integers low and high.
//
//  An integer x consisting of 2 * n digits is symmetric if the sum of the first n digits of x is equal to the sum
//  of the last n digits of x. Numbers with an odd number of digits are never symmetric.
//
//  Return the number of symmetric integers in the range [low, high].
//
//  Example 1:
//    Input: low = 1, high = 100
//    Output: 9
//    Explanation: There are 9 symmetric integers between 1 and 100: 11, 22, 33, 44, 55, 66, 77, 88, and 99.
//
//  Example 2:
//    Input: low = 1200, high = 1230
//    Output: 4
//    Explanation: There are 4 symmetric integers between 1200 and 1230: 1203, 1212, 1221, and 1230.
//----------------------------------------------------------------------------------------------------------------------

package Problem2843;

public class CountSymmetricIntegers {
    public static void main(String[] args) {
        int low = 1200, high = 1230;

        System.out.println(countSymmetricIntegers(low, high));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        // Iterate through the numbers from low to high
        for (int current = low; current <= high; current++) {
            // Ignore numbers with an odd number of digits
            if (Math.floor(Math.log10(current)) % 2 == 1) {
                String number = String.valueOf(current);

                if (number.length() == 2 && (number.charAt(0) == number.charAt(1))) {
                    count++;
                } else {
                    int cutoff = number.length() / 2;

                    String left = number.substring(0, cutoff);
                    String right = number.substring(cutoff);

                    int leftSum = 0;
                    int rightSum = 0;

                    for (int i = 0; i < left.length(); i++) {
                        leftSum += left.charAt(i);
                        rightSum += right.charAt(i);
                    }

                    if (leftSum == rightSum) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
