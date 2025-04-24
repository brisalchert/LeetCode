//----------------------------------------------------------------------------------------------------------------------
//  84. Largest Rectangle in Histogram
//
//  Given an array of integers "heights" representing the histogram's bar height where the width of each bar is 1,
//  return the area of the largest rectangle in the histogram.
//
//  Example 1:
//    Input: heights = [2,1,5,6,2,3]
//    Output: 10
//
//  Example 2:
//    Input: heights = [2,4]
//    Output: 4
//----------------------------------------------------------------------------------------------------------------------

package Problem84;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int[] firstSmallerOnLeft = new int[heights.length];
        int[] firstSmallerOnRight = new int[heights.length];
        int result = 0;

        // Set first smaller indices for bars on the edge
        firstSmallerOnLeft[0] = -1;
        firstSmallerOnRight[heights.length - 1] = heights.length;

        // Calculate indices of each bar's first smaller bar on the left
        for (int i = 1; i < heights.length; i++) {
            int currentOnLeft = i - 1;

            // Reuse previous values to avoid redundant calculations
            while (currentOnLeft >= 0 && heights[currentOnLeft] >= heights[i]) {
                currentOnLeft = firstSmallerOnLeft[currentOnLeft];
            }

            firstSmallerOnLeft[i] = currentOnLeft;
        }

        // Calculate indices of each bar's first smaller bar on the right
        for (int i = heights.length - 2; i >= 0; i--) {
            int currentOnRight = i + 1;

            // Reuse previous values to avoid redundant calculations
            while (currentOnRight < heights.length && heights[currentOnRight] >= heights[i]) {
                currentOnRight = firstSmallerOnRight[currentOnRight];
            }

            firstSmallerOnRight[i] = currentOnRight;
        }

        // Calculate the area of each rectangle
        for (int i = 0; i < heights.length; i++) {
            result = Math.max(result, heights[i] * (firstSmallerOnRight[i] - firstSmallerOnLeft[i] - 1));
        }

        return result;
    }
}
