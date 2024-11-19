//----------------------------------------------------------------------------------------------------------------------
//  23. Merge K Sorted Lists
//
//  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//  Merge all the linked-lists into one sorted linked-list and return it.
//
//  Example 1:
//    Input: lists = [[1,4,5],[1,3,4],[2,6]]
//    Output: [1,1,2,3,4,4,5,6]
//    Explanation: The linked-lists are:
//    [
//      1->4->5,
//      1->3->4,
//      2->6
//    ]
//    merging them into one sorted list:
//    1->1->2->3->4->4->5->6
//
//  Example 2:
//    Input: lists = []
//    Output: []
//
//  Example 3:
//    Input: lists = [[]]
//    Output: []
//----------------------------------------------------------------------------------------------------------------------

package Problem23;

import java.util.TreeMap;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        ListNode list3 = new ListNode(2);

        list1.next = new ListNode(4, new ListNode(5));
        list2.next = new ListNode(3, new ListNode(4));
        list3.next = new ListNode(6);

        ListNode[] input = {list1, list2, list3};

        ListNode mergedList = mergeKLists(input);

        while (mergedList != null) {
            System.out.println(mergedList.val);
            mergedList = mergedList.next;
        }
    }

    /**
     * Merges k linked lists of integers, where each list is presorted in ascending order.
     * Uses recursive algorithm similar to merge sort's divide and conquer
     * @param lists the list of linked lists
     * @return the merged list
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        // Base cases for recursion
        if (start == end) {
            return lists[start];
        }

        if (start + 1 == end) {
            return merge(lists[start], lists[end]);
        }

        // Find the midpoint of the lists between start and end
        int mid = start + (end - start) / 2;

        // Merge the left and right halves recursively
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        // Merge the halves together
        return merge(left, right);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        // Dummy node for head of merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    /**
     * Merges k linked lists of integers, where each list is presorted in ascending order.
     * Utilizes a TreeMap to find the previous node in the merged list for each new node
     * by finding the last node with equal or lesser value.
     * @param lists the list of linked lists
     * @return the merged list
     */
    public static ListNode mergeKListsTree(ListNode[] lists) {
        // Case for empty input
        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode result = null;

        // Initialize TreeMap of integers to last node with that value
        TreeMap<Integer, ListNode> valueMap = new TreeMap<>();

        // Iterate through the list of lists
        for (ListNode list : lists) {
            ListNode current = list;

            // Iterate through each node in the inner list
            while (current != null) {
                // Save reference to next node in the list
                ListNode next = current.next;

                // Get the key or closest key below in the TreeMap
                Integer closestKey = valueMap.floorKey(current.val);

                // If there is no closest key below
                if (closestKey == null) {
                    // Insert node at head
                    current.next = result;
                    result = current;
                } else {
                    // Append the node after the last value less than or equal
                    ListNode last = valueMap.get(closestKey);

                    current.next = last.next;
                    last.next = current;
                }

                // Add the node to the TreeMap
                valueMap.put(current.val, current);

                current = next;
            }
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
