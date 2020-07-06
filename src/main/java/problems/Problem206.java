package problems;

import structs.ListNode;

/**
 * 206. 反转链表
 * @author Chen Runwen
 * @difficulty E
 * @status TODO
 * @time 2020/7/5 18:51
 */
public class Problem206 {

    /** 递归写法 19:02，100% 5% */
    ListNode newHead;

    public ListNode reverseList1(ListNode head) {
        if (head == null) return null;
        recurse(head);
        head.next = null;
        return newHead;
    }

    private void recurse(ListNode head) {
        if (head.next == null) {
            newHead = head;
            return;
        }
        recurse(head.next);
        head.next.next = head;
    }

    /** 迭代写法，100% 5% */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode p = head.next, q;
        head.next = null;
        while (p != null) {
             q = p.next;
             p.next = head;
             head = p;
             p = q;
        }

        return head;
    }

}
