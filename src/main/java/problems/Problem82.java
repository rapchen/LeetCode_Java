package problems;

import structs.ListNode;

/**
 * 82. 删除排序链表中的重复元素 II
 * @author Chen Runwen
 * @difficulty M
 * @status AC 92% 6%
 * @time 2020/7/7 23:07 - 23:27
 */
public class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode p0 = null, p = head;
        while (p != null && p.next != null) {
            if (p.val != p.next.val) {
                p0 = p;
                p = p.next;
            } else {
                while (p.next != null && p.val == p.next.val) p = p.next;
                p = p.next;
                if (p0 == null) head = p;
                else p0.next = p;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,3,4,4,5});
        ListNode res = new Problem82().deleteDuplicates(head);
        System.out.println(ListNode.valuesToString(res));
    }
}
