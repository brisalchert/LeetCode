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

import java.util.ArrayList;

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

    public static ListNode mergeKLists(ListNode[] lists) {
        return null;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
