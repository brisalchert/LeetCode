//----------------------------------------------------------------------------------------------------------------------
//  19. Remove Nth Node From End of List
//
//  Given the head of a linked list, remove the nth node from the end of the list and return its head.
//----------------------------------------------------------------------------------------------------------------------

package Problem19;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 5;

        head = removeNthFromEnd(head, n);

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize two pointers, one to traverse the list and
        // another to find the node previous to the nth from the end
        ListNode leading = head;
        ListNode lagging = head;

        // If the list has one element, return null
        if (leading.next == null) {
            return null;
        }

        // Move the leading pointer n nodes ahead of the lagging pointer
        for (int i = 0; i < n; i++) {
            leading = leading.next;
        }

        // If leading is null (meaning n is the length of the list),
        // then remove the head of the list and return
        if (leading == null) {
            return head.next;
        }

        // Move both pointers until the leading pointer reaches the end of the list
        while (leading.next != null) {
            leading = leading.next;
            lagging = lagging.next;
        }

        // Unlink the nth node from the end of the list
        ListNode prev = lagging;
        ListNode toRemove = lagging.next;
        prev.next = prev.next.next;
        toRemove.next = null;

        return head;
    }
}
