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
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 1;

        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Create a loop
        current.next = head;

        // Calculate k as the index of the new head node
        k = k % length;
        k = length - k;

        // Traverse to the node just before the new head
        while (k-- > 0) {
            current = current.next;
        }

        // Set new head and tail nodes
        head = current.next;
        current.next = null;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
