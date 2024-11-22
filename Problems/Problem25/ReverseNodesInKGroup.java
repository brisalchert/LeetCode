//----------------------------------------------------------------------------------------------------------------------
//  25. Reverse Nodes in k-Group
//
//  Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
//
//  k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
//  a multiple of k then left-out nodes, in the end, should remain as it is.
//
//  You may not alter the values in the list's nodes, only nodes themselves may be changed.
//
//  Example 1:
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [2,1,4,3,5]
//
//  Example 2:
//    Input: head = [1,2,3,4,5], k = 3
//    Output: [3,2,1,4,5]
//----------------------------------------------------------------------------------------------------------------------

package Problem25;

public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode reversed = reverseKGroup(head, k);

        while (reversed != null) {
            System.out.println(reversed.val);
            reversed = reversed.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
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
