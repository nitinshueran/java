package com.shu.nitin.leetcode;

import java.util.List;

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
        List<Integer> test =  Arrays.asList(1,1,1).sort((x,y) -> x.compareTo(y));
        Map<Integer, Integer> test = new HashMap<>();
        test.containsKey(key)
        if (number == reverse)
            return true;

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
