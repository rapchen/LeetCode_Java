package contests.c20250406;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Q4. 移除最小数对使数组有序 II
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public static class ListNode {
        int value;
        ListNode last;
        ListNode next;

        public ListNode(int value, ListNode last) {
            this.value = value;
            this.last = last;
            if (last != null) {
                last.next = this;
            }
        }
    }

    public int minimumPairRemoval(int[] nums) {
        ListNode head = new ListNode(nums[0], null);
        ListNode tail = head;
        for (int i = 1; i < nums.length; i++) {
            tail = new ListNode(nums[i], tail);
        }
        return 0;
    }
}
