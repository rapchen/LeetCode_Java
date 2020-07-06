package problems;

import structs.ListNode;

/**
 * 24. 两两交换链表中的节点
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 6%
 * @time 2020/7/5 18:33
 */
public class Problem24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode o, p, q;

        q = head.next;
        if (q == null) return head;
        head.next = q.next;
        q.next = head;
        head = q;
        o = q.next;

        while (o.next != null) {
            p = o.next;
            q = p.next;
            if (q == null) return head;
            p.next = q.next;
            q.next = p;
            o.next = q;
            o = p;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
