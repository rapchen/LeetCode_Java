package problems;

import structs.ListNode;

/**
 * 92. 反转链表 II
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 8%
 * @time 2020/7/6 21:57
 */
public class Problem92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        // p0保存第m个节点的前一个节点（除非m==1）。p1p2p3随反向操作的迭代而移动，p2是当前要更改指向的节点，p1p3分别是其左右的邻居
        ListNode p0 = head, p1, p2, p3;
        for (int i = 1; i < m - 1; i++) p0 = p0.next;
        p1 = m == 1 ? p0 : p0.next;
        p2 = p1.next;
        for (int i = m; i < n; i++) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }

        if (m == 1) {
            p0.next = p2;
            return p1;
        }

        p0.next.next = p2;
        p0.next = p1;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4,5});
//        int m = 2, n = 4;
//        int m = 1, n = 4;
//        int m = 2, n = 5;
        int m = 1, n = 5;
        ListNode res = new Problem92().reverseBetween(head, m, n);
        System.out.println(ListNode.valuesToString(res));
    }
}
