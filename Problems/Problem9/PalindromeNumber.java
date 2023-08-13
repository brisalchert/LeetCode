//----------------------------------------------------------------------------------------------------------------------
//  9. Palindrome Number
//
//  Given an integer x, return true if x is a palindrome, and false otherwise.
//----------------------------------------------------------------------------------------------------------------------

package Problem9;

public class PalindromeNumber {
    public static void main(String[] args) {
        int input = 1345431;

        System.out.println(isPalindrome(input));
    }

    /**
     * Returns true if the input integer is palindromic, false otherwise
     * @param x the input integer
     * @return true if x is a palindrome
     */
    public static boolean isPalindrome(int x) {
        // Case for negative numbers (minus sign means it cannot be a palindrome)
        if (x < 0) {
            return false;
        }

        // Trivial case for one-digit number
        if (x < 10) {
            return true;
        }

        char[] digitArray = Integer.toString(x).toCharArray();
        int leftIndex = 0;
        int rightIndex = digitArray.length - 1;

        while ((leftIndex < rightIndex) && (digitArray[leftIndex] == digitArray[rightIndex])) {
            leftIndex++;
            rightIndex--;
        }

        return leftIndex >= rightIndex;
    }
}
