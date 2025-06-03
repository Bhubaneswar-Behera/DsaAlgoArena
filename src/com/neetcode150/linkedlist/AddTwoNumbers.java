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
            sum = sum % 10;
            currentNode.next = new ListNode(sum);
            currentNode = currentNode.next;
        }

        if (carry == 1) {
            currentNode.next = new ListNode(1);
        }

        return result.next;

    }
}
