package problems;

import structs.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 5%
 * @time 2020/7/5 11:32
 */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, q = head;
        for (int i = 0; i < n; i++)
            p = p.next;
        if (p == null) {
            // 头结点正好是倒数第N个，删除头结点
            head = head.next;
            return head;
        } else
            p = p.next;
        while (p != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {

    }
}
