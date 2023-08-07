//----------------------------------------------------------------------------------------------------------------------
//  4. Median of Two Sorted Arrays
//
//  Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
//
//  The overall run time complexity should be O(log (m+n)).
//----------------------------------------------------------------------------------------------------------------------

package Problem4;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int maxLeft1, maxLeft2;
        int minRight1, minRight2;

        // Ensure that the first array is the smaller array
        if (size1 > size2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        // Define left and right for binary search by the size of the first array
        int left = 0;
        int right = size1;

        // Using binary search, find the partition of both arrays that divides the combined array into two equally
        // sized parts, where the elements of the left halves are less than or equal to the elements of the right halves
        while (left <= right) {
            int mid1 = (left + right) / 2;
            int mid2 = (size1 + size2 + 1) / 2 - mid1;  // Defining mid2 by mid2 ensures the two parts are equal

            // Set the max of the first array's left half, or nullify if the left half is empty
            if (mid1 == 0) {
                maxLeft1 = Integer.MIN_VALUE;
            }
            else {
                maxLeft1 = nums1[mid1 - 1];
            }

            // Set the min of the first array's right half, or nullify if the right half is empty
            if (mid1 == size1) {
                minRight1 = Integer.MAX_VALUE;
            }
            else {
                minRight1 = nums1[mid1];
            }

            // Set the max of the second array's left half, or nullify if the left half is empty
            if (mid2 == 0) {
                maxLeft2 = Integer.MIN_VALUE;
            }
            else {
                maxLeft2 = nums2[mid2 - 1];
            }

            // Set the min of the second array's right half, or nullify if the right half is empty
            if (mid2 == size2) {
                minRight2 = Integer.MAX_VALUE;
            }
            else {
                minRight2 = nums2[mid2];
            }

            // Check to see if the partitions successfully divide the arrays such that the left halves contain
            // elements less than or equal to the elements of the right halves
            if ((maxLeft1 <= minRight2) &&(maxLeft2 <= minRight1)) {
                // Case for even number of combined elements
                if ((size1 + size2) % 2 == 0) {
                    return ((double) (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2);
                }
                // Case for odd number of combined elements
                else {
                    return (Math.max(maxLeft1, maxLeft2));
                }
            }
            else {
                // Check if the left half of the first array contains elements greater than those of the right half
                // of the second array
                if (maxLeft1 > minRight2) {
                    // Change the right index to move the partition to the middle of the left half of the first array
                    right = mid1 - 1;
                }
                else {
                    // Change the left index to move the partition to the middle of the right half of the first array
                    left = mid1 + 1;
                }
            }
        }

        return -1;
    }
}
