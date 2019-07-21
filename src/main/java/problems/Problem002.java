package problems;

/**
 * @author Chen Runwen
 * @version 1.0 2018/3/4
 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
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
}

public class Problem002 {
    public static void main(String[] args) {

    }
}
