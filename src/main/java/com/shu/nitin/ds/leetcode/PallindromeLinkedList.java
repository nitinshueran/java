package com.shu.nitin.ds.leetcode;

public class PallindromeLinkedList {

    public static void main(String[] args) {
        ListNode child = new ListNode(1, null);
        ListNode p1 = new ListNode(2, child);
        ListNode p2 = new ListNode(2, p1);
        ListNode head = new ListNode(1, p2);

        System.out.println();
        ;
        isPalindrome(head);
    }

    public static boolean isPalindrome(ListNode head) {
        double number = 0;
        while (head != null) {
            number = number * 10 + head.val;
            head = head.next;
        }

        double tmp = number; // 191
        double reverse = 0;
        while (tmp > 0) {
            reverse = reverse * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        return false;
    }
}

class ListNode {
    int val;

    ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
