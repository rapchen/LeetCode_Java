package problems;

import structs.ListNode;

/**
 * 61. 旋转链表
 * @author Chen Runwen
 * @difficulty M
 * @status AC 85% 5%
 * @time 2020/7/7 22:42 - 22:52
 */
public class Problem61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) return head;
        
        // 第一次遍历获取链表长度，并把首尾相连
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        p.next = head;

        // 第二次遍历找到对应的结点断开
        for (int i = 0; i < len - k % len; i++) p = p.next;
        head = p.next;
        p.next = null;
        return head;
    }

    public static void main(String[] args) {

    }
}
