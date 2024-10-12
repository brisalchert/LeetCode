//----------------------------------------------------------------------------------------------------------------------
//  19. Remove Nth Node From End of List
//
//  Given the head of a linked list, remove the nth node from the end of the list and return its head.
//----------------------------------------------------------------------------------------------------------------------

package Problem19;

public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return head;
    }
}
