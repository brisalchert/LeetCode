//----------------------------------------------------------------------------------------------------------------------
//  42. Trapping Rain Water
//
//  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much
//  water it can trap after raining.
//
//  Example 1:
//    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    Output: 6
//    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
//    this case, 6 units of rain water (blue section) are being trapped.
//
//  Example 2:
//    Input: height = [4,2,0,3,2,5]
//    Output: 9
//----------------------------------------------------------------------------------------------------------------------

package Problem42;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int trapped = 0;

        // Create left and right pointers and track max left and right heights
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                // Check for new left max
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    // Add trapped water
                    trapped += leftMax - height[left];
                }

               // Increment left pointer
                left++;
            } else {
                // Check for new right max
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    // Add trapped water
                    trapped += rightMax - height[right];
                }

                // Decrement right pointer
                right--;
            }
        }

        return trapped;
    }
}
