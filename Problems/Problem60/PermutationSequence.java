//----------------------------------------------------------------------------------------------------------------------
//  60. Permutation Sequence
//
//  The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
//
//  By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
//
//  1. "123"
//  2. "132"
//  3. "213"
//  4. "231"
//  5. "312"
//  6. "321"
//
//  Given n and k, return the kth permutation sequence.
//
//  Example 1:
//    Input: n = 3, k = 3
//    Output: "213"
//----------------------------------------------------------------------------------------------------------------------

package Problem60;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static void main(String[] args) {
        int n = 4;
        int k = 9;

        System.out.println(getPermutation(n, k));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--; // For indexing

        for (int i = 1; i <= n; i++) {
            int index = k / factorial(n - i);
            sb.append(numbers.get(index));
            numbers.remove(index);
            k -= index * factorial(n - i);
        }

        return sb.toString();
    }

    public static int factorial(int n) {
        if (n <= 1) return 1;

        int result = n;

        for (int i = 1; i < n - 1; i++) {
            result *= (n - i);
        }

        return result;
    }
}
