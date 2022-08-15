package com.wakeupyoung.linked.list;

import com.wakeupyoung.Solution;
import com.wakeupyoung.linked.list.common.ListNode;

public class MergeTwoOrderedList implements Solution<ListNode, Input> {
    ListNode dummy = new ListNode(-1);
    ListNode p = dummy;

    @Override
    public ListNode resolve(Input input) {
        while (input.node1 != null && input.node2 != null) {
            if (input.node1.val > input.node2.val) {
                p.next = input.node2;
                input.node2 = input.node2.next;
            } else {
                p.next = input.node1;
                input.node1 = input.node1.next;
            }
            p = p.next;
        }
        if (input.node1 != null) {
            p.next = input.node1;
        }
        if (input.node2 != null) {
            p.next = input.node2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Input input = new Input();
        input.node1 = ListNode.buildFromArray(new int[]{
                1, 2, 4
        });
        input.node2 = ListNode.buildFromArray(new int[]{
                1, 3, 4
        });
        System.out.println(new MergeTwoOrderedList().resolve(input));
    }

}

class Input {
    ListNode node1;
    ListNode node2;
}
