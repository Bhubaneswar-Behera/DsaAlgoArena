package com.neetcode150.linkedlist;

/**
 *
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * Reference : https://www.youtube.com/watch?v=_GBo_CgST1M
 */
public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val  = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a copy of each node and insert it next to the original node
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }
        // Step 2: Set the "random pointers" for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
        // Step 3: Separate the copied nodes from the original list
        Node original = head;
        Node newHead = head.next;
        Node newCurr = newHead;
        while (original != null) {
            original.next = newCurr.next;
            original = original.next;
            if (original != null) {
                newCurr.next = original.next;
                newCurr = newCurr.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {

    }
}
