//----------------------------------------------------------------------------------------------------------------------
//  2. Adding Two Numbers
//
//  You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
//  order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
//
//  You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//----------------------------------------------------------------------------------------------------------------------

package Problem2;

import java.util.Stack;

public class AddingTwoNumbers {
    public static void main(String[] args) {
        int[] l1 = {9};
        int[] l2 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        ListNode firstList = new ListNode();
        ListNode secondList = new ListNode();

        // Initialize lists
        initializeList(l1, firstList);
        initializeList(l2, secondList);

        // Add the lists
        ListNode result = addTwoNumbers(firstList, secondList);

        // Print the result
        ListNode current = result;
        Stack reverseStack = new Stack<>();

        while (current != null) {
            reverseStack.push(current.val);
            current = current.next;
        }

        while (!reverseStack.isEmpty()) {
            System.out.print(reverseStack.pop());
        }
    }

    /**
     * Adds two numbers stored in reverse order as LinkedLists
     * @param l1 the first list
     * @param l2 the second list
     * @return a list with the sum stored in reverse order
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode firstIndex = l1;
        ListNode secondIndex = l2;
        ListNode resultIndex = temp;
        int carry = 0;

        while ((firstIndex != null) || (secondIndex != null) || (carry == 1)) {
            int sum = 0;

            if (firstIndex != null) {
                // Add the value from the first list
                sum += firstIndex.val;
                firstIndex = firstIndex.next;
            }

            if (secondIndex != null) {
                // Add the value from the second list
                sum += secondIndex.val;
                secondIndex = secondIndex.next;
            }

            // Add the carry
            sum += carry;

            // Get the new carry
            carry = sum / 10;

            // Create a new node with the value of the first digit of the sum
            ListNode node = new ListNode(sum % 10);

            // Add the new node to the list
            resultIndex.next = node;
            resultIndex = resultIndex.next;
        }

        // Return the list without the initial temporary node
        return temp.next;
    }

    /**
     * Converts an integer array into a LinkedList using ListNodes
     * @param list the integer array
     * @param node the first node of the new LinkedList
     * @return the first node of the new LinkedList
     */
    public static ListNode initializeList(int[] list, ListNode node) {
        ListNode current;
        ListNode prev;

        // Set the value of the first node
        node.val = list[0];
        prev = node;

        // Set the values for subsequent nodes
        for (int index = 1; index < list.length; index++) {
            current = new ListNode(list[index]);
            prev.next = current;
            prev = current;
        }

        return node;
    }

    /**
     * Provided class defining a ListNode with several constructors
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
