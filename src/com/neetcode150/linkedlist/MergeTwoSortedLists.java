package com.neetcode150.linkedlist;

import static com.neetcode150.linkedlist.ListNode1.mergeTwoLists;

/**
 *
 *
 */
 class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1() {}

    ListNode1(int val) {
        this.val = val;
    }

    ListNode1(int val, ListNode1 next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode1 mergeTwoLists(ListNode1 list1, ListNode1 list2) {
        ListNode1 listNode = new ListNode1(0);
        ListNode1 current = listNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return listNode.next;
    }

    public static void printList(ListNode1 head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}




public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode1 list1 = new ListNode1(1);
        list1.next = new ListNode1(2);
        list1.next.next = new ListNode1(4);

        ListNode1 list2 = new ListNode1(1);
        list2.next = new ListNode1(3);
        list2.next.next = new ListNode1(4);

        ListNode1 mergedList = mergeTwoLists(list1, list2);
        list1.printList(mergedList);
    }
}
