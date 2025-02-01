//----------------------------------------------------------------------------------------------------------------------
//  3151. Special Array I
//
//  An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
//
//  You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
//
//  Example 1:
//    Input: nums = [1]
//    Output: true
//    Explanation: There is only one element. So the answer is true.
//
//  Example 2:
//    Input: nums = [2,1,4]
//    Output: true
//    Explanation: There is only two pairs: (2,1) and (1,4), and both of them contain numbers with different parity.
//    So the answer is true.
//----------------------------------------------------------------------------------------------------------------------

package Problem3151;

public class SpecialArray1 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6};

        System.out.println(isArraySpecial(nums));
    }

    public static boolean isArraySpecial(int[] nums) {
        return false;
    }
}
