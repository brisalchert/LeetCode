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
        // Base cases for no reversing
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 1) {
            return head;
        }

        // Check that there are enough nodes to begin with
        ListNode temp = head;
        int count = 0;
        while (temp != null && count < k) {
            count++;
            temp = temp.next;
        }

        if (count < k) {
            return head;
        }

        // Initialize a dummy node before the head node
        ListNode dummy = new ListNode(0, head);

        // Initialize previous to the dummy node
        ListNode previous = dummy;

        // Initialize current to the head node
        ListNode current = head;

        while (true) {
            // Point the previous node to node k
            ListNode kNode = current;
            for (int i = 1; i < k; i++) {
                kNode = kNode.next;
            }

            previous.next = kNode;

            // Save a reference to the node after the k-group
            ListNode after = kNode.next;

            // Use recursive helper method to reverse the inner nodes of the k-group
            reverseGroupHelper(current, 2, k);

            // Point the first node in the k-group to the node after node k
            current.next = after;

            // If there are more nodes to swap, update pointers and continue
            int num_remaining = 0;

            while (after != null && num_remaining < k) {
                num_remaining++;
                after = after.next;
            }

            if (num_remaining < k) {
                break;
            } else {
                previous = current;
                current = previous.next;
            }
        }

        return dummy.next;
    }

    private static void reverseGroupHelper(ListNode previous, int j, int k) {
        // Base case: reverse the last node in the k-group
        if (j == k) {
            // Reverse the current node to point to the previous node
            previous.next.next = previous;

            return;
        }

        // Recursive case: reverse further nodes, then reverse this node
        reverseGroupHelper(previous.next, j + 1, k);

        previous.next.next = previous;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
