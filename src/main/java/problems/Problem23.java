package problems;

import algorithm.pq.IndexedMinPriorityQueue;
import structs.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 * @author Chen Runwen
 * @difficulty H
 * @status AC 82% 52%
 * @time 2020/7/5 15:23 - 17:00
 */
public class Problem23 {
    /** 原生优先队列，36% 52% */
    public ListNode mergeKLists1(ListNode[] lists) {
        int len = lists.length, k;
        if (len == 0) return null;
        ListNode head, tail;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> lists[a].val));
        for (int i = 0; i < len; i++)
            if (lists[i] != null) pq.add(i);
        if (pq.size() == 0) return null;

        // 先取1个作为头
        k = pq.poll();
        head = tail = lists[k];
        lists[k] = lists[k].next;
        if (lists[k] != null) pq.add(k);

        while (!pq.isEmpty()) {
            k = pq.poll();
            tail.next = lists[k];
            tail = tail.next;

            lists[k] = lists[k].next;
            if (lists[k] != null) pq.add(k);
        }

        return head;
    }

    /** 自己写优先队列，82% 52% */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length, k;
        if (len == 0) return null;
        ListNode head, tail;
        IndexedMinPriorityQueue pq = new IndexedMinPriorityQueue(len);
        for (int i = 0; i < len; i++)
            if (lists[i] != null) pq.insert(lists[i].val, i);
        if (pq.size == 0) return null;

        // 先取1个作为头
        k = pq.deleteMin();
        head = tail = lists[k];
        lists[k] = lists[k].next;
        if (lists[k] != null) pq.insert(lists[k].val, k);

        while (!(pq.size == 0)) {
            k = pq.deleteMin();
            tail.next = lists[k];
            tail = tail.next;

            lists[k] = lists[k].next;
            if (lists[k] != null) pq.insert(lists[k].val, k);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{};
        System.out.println(new Problem23().mergeKLists(lists));
    }
}
