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

        // Create indices for the left and right walls of the current
        // water container, as well as the current max right height
        int leftIndex = 0;
        int rightIndex = 1;
        int maxRightIndex = 1;

        // Find instances where right wall height matches or exceeds
        // left wall height
        while (leftIndex < height.length) {
            // If right wall shorter than left wall, calculate trapped water
            if (rightIndex == height.length) {
                for (int i = leftIndex + 1; i < maxRightIndex; i++) {
                    trapped += height[maxRightIndex] - height[i];
                }

                // Set new left wall and begin search for new right wall
                leftIndex = maxRightIndex;
                rightIndex = leftIndex + 1;
                maxRightIndex = rightIndex;
            } else if (height[rightIndex] >= height[leftIndex]) {
                // If left wall shorter than right wall, calculate trapped water
                for (int i = leftIndex + 1; i < rightIndex; i++) {
                    trapped += height[leftIndex] - height[i];
                }

                // Set new left wall and begin search for new right wall
                leftIndex = rightIndex;
                rightIndex++;
                maxRightIndex = rightIndex;
            } else {
                // Set new max right height
                if (height[rightIndex] >= height[maxRightIndex]) {
                    maxRightIndex = rightIndex;
                }

                // Keep searching for right wall
                rightIndex++;
            }
        }

        return trapped;
    }
}
