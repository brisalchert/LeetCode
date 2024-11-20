//----------------------------------------------------------------------------------------------------------------------
//  24. Swap Nodes in Pairs
//
//  Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without
//  modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
//
//  Example 1:
//    Input: head = [1,2,3,4]
//    Output: [2,1,4,3]
//----------------------------------------------------------------------------------------------------------------------

package Problem24;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(swapPairs(head));
    }

    public static ListNode swapPairs(ListNode head) {
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
