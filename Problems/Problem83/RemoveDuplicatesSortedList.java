//----------------------------------------------------------------------------------------------------------------------
//  83. Remove Duplicates from Sorted List
//
//  Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
//  Return the linked list sorted as well.
//
//  Example 1:
//    Input: head = [1,1,2]
//    Output: [1,2]
//
//  Example 2:
//    Input: head = [1,1,2,3,3]
//    Output: [1,2,3]
//----------------------------------------------------------------------------------------------------------------------

package Problem83;

public class RemoveDuplicatesSortedList {
    public static void main(String[] args) {
        int[] values = {1,1,2,3,3};
        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        head = deleteDuplicates(head);
        current = head;

        System.out.print("[");

        while (current != null) {
            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(", ");
            }

            current = current.next;
        }

        System.out.println("]");
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

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
