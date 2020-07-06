package problems;

import structs.ListNode;

/**
 * 25. K 个一组翻转链表
 * @author Chen Runwen
 * @difficulty H
 * @status AC 47% 7%
 * @time 2020/7/6 23:02
 */
public class Problem25 {
    /** 47% 7% */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        // 先翻转第一组。p1p2p3随反向操作的迭代而移动，p2是当前要更改指向的节点，p1p3分别是其左右的邻居。
        ListNode p0, p1 = head, p2 = p1.next, p3 = null;
        for (int i = 1; i < k; i++) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        head.next = p2;
        p0 = head;
        head = p1;

        // 第二组以后的部分。p0保存上一组翻转过后的最后一个节点
        while (true) {
            // 判断是否满K个，不满直接返回
            for (int i = 0; i < k; i++) {
                if (p3 == null) return head;
                p3 = p3.next;
            }

            p1 = p2;
            p2 = p1.next;
            for (int i = 1; i < k; i++) {
                p3 = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p3;
            }
            p3 = p0.next;
            p3.next = p2;
            p0.next = p1;
            p0 = p3;
            p3 = p2;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4,5});
        int k = 2;
        ListNode res = new Problem25().reverseKGroup(head, k);
        System.out.println(ListNode.valuesToString(res));
    }
}
