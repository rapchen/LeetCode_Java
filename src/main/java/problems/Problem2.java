package problems;

import structs.ListNode;

/**
 * 2. 两数相加
 * @difficulty M
 * @author Chen Runwen
 * @time 2018/3/4
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p1Last = l1;
        int overflow = 0;
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + overflow;
            overflow = sum / 10;
            p1.val = sum % 10;
            p1Last = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        while (p1 != null) {
            sum = p1.val + overflow;
            overflow = sum / 10;
            p1.val = sum % 10;
            p1Last = p1;
            p1 = p1.next;
        }
        while (p2 != null) {
            sum = p2.val + overflow;
            overflow = sum / 10;
            ListNode p = new ListNode(sum % 10);
            p1Last.next = p;
            p1Last = p;
            p2 = p2.next;
        }
        if (overflow != 0) {
            ListNode p = new ListNode(overflow);
            p1Last.next = p;
        }
        return l1;
    }

    public static void main(String[] args) {
        int[] ratings = new int[] {1, 2, 2};
        System.out.println(new Problem135().candy(ratings));
    }
}
