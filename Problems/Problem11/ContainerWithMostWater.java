//----------------------------------------------------------------------------------------------------------------------
//  11. Container With Most Water
//
//  You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
//  the ith line are (i, 0) and (i, height[i]).
//
//  Find two lines that together with the x-axis form a container, such that the container contains the most water.
//
//  Return the maximum amount of water a container can store.
//
//  Notice that you may not slant the container.
//----------------------------------------------------------------------------------------------------------------------

package Problem11;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(height));
    }

    /**
     * Finds the maximum area of water stored by a container formed from vertical lines from an array of heights
     * @param height the array of heights
     * @return the maximum area of a container formed from the heights
     */
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        int leftIndex = 0;
        int rightIndex = (height.length - 1);

        // Stop when leftIndex reaches rightIndex
        while (leftIndex < rightIndex) {
            int area = (rightIndex - leftIndex) * (Math.min(height[leftIndex], height[rightIndex]));

            if (area > maxArea) {
                maxArea = area;
            }

            // Send the index of the smaller height inwards, or both if heights are equal
            if (height[leftIndex] < height[rightIndex]) {
                leftIndex++;
            }
            else {
                if (height[rightIndex] == height[leftIndex]) {
                    leftIndex++;
                }

                rightIndex--;
            }
        }

        return maxArea;
    }
}
