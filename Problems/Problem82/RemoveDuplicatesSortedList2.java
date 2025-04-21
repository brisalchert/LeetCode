//----------------------------------------------------------------------------------------------------------------------
//  82. Remove Duplicates from Sorted List II
//
//  Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
//  numbers from the original list. Return the linked list sorted as well.
//
//  Example 1:
//    Input: head = [1,2,3,3,4,4,5]
//    Output: [1,2,5]
//
//  Example 2:
//    Input: head = [1,1,1,2,3]
//    Output: [2,3]
//----------------------------------------------------------------------------------------------------------------------

package Problem82;

public class RemoveDuplicatesSortedList2 {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 3, 4, 4, 5};
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

        ListNode dummy = new ListNode(0, head);
        ListNode previous = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (current.next != null && current.next.val == current.val) {
                    current = current.next;
                }

                // Unlink all duplicate values
                previous.next = current.next;
            } else {
                // Advance previous pointer when nodes are not duplicates
                previous = current;
            }

            current = current.next;
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
