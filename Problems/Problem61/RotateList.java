//----------------------------------------------------------------------------------------------------------------------
//  61. Rotate List
//
//  Given the head of a linked list, rotate the list to the right by k places.
//
//  Example 1:
//    Input: head = [1,2,3,4,5], k = 2
//    Output: [4,5,1,2,3]
//----------------------------------------------------------------------------------------------------------------------

package Problem61;

public class RotateList {
    private static int kAdj;
    private static ListNode headAdj;

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 0; i < 4; i++) {
            current.next = new ListNode(i + 2);
            current = current.next;
        }

        head = rotateRight(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        kAdj = -1;
        headAdj = head;

        rotateBacktrack(head, k, 0);

        return headAdj;
    }

    private static void rotateBacktrack(ListNode current, int k, int index) {
        if (current.next != null) {
            rotateBacktrack(current.next, k, index + 1);
        } else {
            // At the end of the list, calculate kAdj, create a loop and begin backtracking
            int size = index + 1;
            kAdj = k % size;
            kAdj = size - 1 - kAdj;
            current.next = headAdj;
        }

        if (index == kAdj) {
            // Set new head and tail nodes by adjusting pointers
            headAdj = current.next;
            current.next = null;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
