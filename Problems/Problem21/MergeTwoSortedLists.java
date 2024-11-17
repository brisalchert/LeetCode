//----------------------------------------------------------------------------------------------------------------------
//  21. Merge Two Sorted Lists
//
//  You are given the heads of two sorted linked lists list1 and list2.
//
//  Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two
//  lists.
//
//  Return the head of the merged linked list.
//----------------------------------------------------------------------------------------------------------------------

package Problem21;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = listFromArray(new int[] {1, 2, 4, 5, 7});
        ListNode l2 = listFromArray(new int[] {1, 3, 4});

        ListNode merged = mergeTwoLists(l1, l2);

        System.out.print("[");

        while (merged != null) {
            System.out.print(merged.val);
            merged = merged.next;

            if (merged != null) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current_left = list1;
        ListNode current_right = list2;
        ListNode result = null;
        ListNode current_result;

        // Case for empty lists
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // Set the head node of the result list
        if (current_left.val <= current_right.val) {
            result = current_left;
            current_left = current_left.next;
        } else {
            result = current_right;
            current_right = current_right.next;
        }

        // Assign current_result
        current_result = result;

        // Iterate through the lists, appending the next smallest element until one list is exhausted
        while (current_left != null && current_right != null) {
            if (current_left.val <= current_right.val) {
                // Append value from left list and increment
                current_result.next = current_left;
                current_left = current_left.next;
            } else {
                // Append value from right list and increment
                current_result.next = current_right;
                current_right = current_right.next;
            }

            // Increment the result pointer
            current_result = current_result.next;
        }

        // Merge remaining elements from the left list
        while (current_left != null) {
            current_result.next = current_left;
            current_left = current_left.next;
            current_result = current_result.next;
        }

        // Merge remaining elements from right list
        while (current_right != null) {
            current_result.next = current_right;
            current_right = current_right.next;
            current_result = current_result.next;
        }

        // Return the head of the merged list
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public void append(int val) {
            this.next = new ListNode(val);
        }
    }

    public static ListNode listFromArray(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;
            current = current.next;
        }

        return head;
    }
}
