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

        ListNode swapped = swapPairs(head);

        while (swapped != null) {
            System.out.println(swapped.val);
            swapped = swapped.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        // Base case for empty or single-node lists
        if (head == null || head.next == null) {
            return head;
        }

        // Save a reference to the new list head after swapping
        ListNode start = head.next;

        // Initialize previous as a dummy node before the head node
        ListNode previous = new ListNode(0, head);

        while (true) {
            // Initialize first and second
            ListNode first = previous.next;
            ListNode second = first.next;

            // Point previous to second
            previous.next = second;

            // Point first to second's next pointer
            first.next = second.next;

            // Point second to first
            second.next = first;

            // If there are more nodes to swap, increment previous to first's new position
            if (first.next != null && first.next.next != null) {
                previous = first;
            } else {
                break;
            }
        }

        return start;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
