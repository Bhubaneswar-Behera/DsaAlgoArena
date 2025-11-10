package com.neetcode150.linkedlist;

/**
 *
 * https://leetcode.com/problems/add-two-numbers/
 * Reference : https://www.youtube.com/watch?v=KMS0WFxrsT8
 */
public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        // Example usage
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.new ListNode(2, addTwoNumbers.new ListNode(4, addTwoNumbers.new ListNode(3)));
        ListNode l2 = addTwoNumbers.new ListNode(5, addTwoNumbers.new ListNode(6, addTwoNumbers.new ListNode(4)));
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode currentNode = result;

        int carry = 0;    // Set default carry

        while (l1 != null || l2 != null) {

            int sum = 0 + carry;    // Initialize sum

            if (l1 != null) {    // Use number from first list
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {    // Use number from 2nd list
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;    // Get sum and carry
            sum = sum % 10;      // Get the last digit
            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;
        }

        // If there is a carry left
        if (carry == 1) {
            currentNode.next = new ListNode(1);
        }

        return result.next;

    }
}
