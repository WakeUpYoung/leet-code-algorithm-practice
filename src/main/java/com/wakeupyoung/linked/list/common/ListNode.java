package com.wakeupyoung.linked.list.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p/>
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/">url</a>
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        List<Integer> res = new ArrayList<>();
        ListNode node = this;
        while (node != null) {
            res.add(node.val);
            node = node.next;
        }
        return Arrays.toString(res.toArray());
    }

    public static ListNode buildFromArray(int[] input) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        for (int i = 0; i < input.length; i++) {
            ListNode cur = new ListNode(input[i]);
            pre.next = cur;
            pre = cur;
        }
        return head.next;
    }
}
