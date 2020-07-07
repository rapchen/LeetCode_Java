package problems;

import structs.ListNode;

/**
 * 83. 删除排序链表中的重复元素
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 5%
 * @time 2020/7/7 23:01 - 23:06
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode p = head;
        while (p.next != null) {
            if (p.val == p.next.val) p.next = p.next.next;
            else p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
