package problems;

import structs.DoubleListNode;
import structs.ListNode;

/**
 * 76. 最小覆盖子串
 * @difficulty H
 * @status WA
 * @author Chen Runwen
 * @time 2020/4/6 17:43
 */
public class Problem76 {

    /**用单链表，失败了*/
    public String minWindowtest1(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int begin = -1, end = lens; // 最终结果的起止位置

        ListNode[] pos = new ListNode[26]; // 数组每个元素代表一个字母，存储的是一个链表节点，这个节点的next里面存放这个字母最后一次出现的位置

        // 链表按位置从前到后的顺序存储，开头到结尾的位置差即为当前最小子串的长度
        // 先初始化链表，每个的位置都记成-1，即不可用
        ListNode head = new ListNode(-1);
        ListNode tail = head;
        for (char c : t1) {
            if (pos[c - 65] == null) {
                tail.next = new ListNode(-1);
                pos[c - 65] = tail;
                tail = tail.next;
            }
        }

        // 遍历S，对每个字母，把它之前在链表里的节点删掉，在最后插入一个新节点
        for (int i = 0; i < lens; i++) {
            if (pos[s1[i] - 65] != null) {
                // 尾部接上新节点，删除原来节点
                tail.next = new ListNode(i); // 接上新节点
                pos[s1[i] - 65].next = pos[s1[i] - 65].next.next; // 删节点
                pos[s1[i] - 65] = tail; // 把pos数组对应的指针改到新节点的前继节点
                tail = tail.next; // 移动tail


/* 这么写容易乱掉，之后再试
                ListNode newNode = pos[s1[i] - 65].next
                newNode.val = i;
                tail.next = newNode;
                pos[s1[i] - 65].next = pos[s1[i] - 65].next.next;
                pos[s1[i] - 65] = tail;
                tail = tail.next;
                tail.next = null;
*/

                // 判断一下现在是不是最短了
                if (head.next.val != -1 && tail.val - head.next.val < end - begin) {
                    begin = head.next.val;
                    end = tail.val;
                }
            }
        }
        if (begin == -1) {
            return "";
        } else {
            return s.substring(begin, end);
        }
    }

    /**用双链表，失败了，领会错意思了，T里面多个重复字母是都要考虑的*/
    public String minWindow(String s, String t) {
        int lens = s.length();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        int begin = -1, end = lens; // 最终结果的起止位置

        DoubleListNode[] pos = new DoubleListNode[58]; // 数组每个元素代表一个字母，存储的是一个链表节点，里面存放这个字母最后一次出现的位置

        // 链表按位置从前到后的顺序存储，开头到结尾的位置差即为当前最小子串的长度
        // 先初始化链表，每个的位置都记成-1，即不可用
        DoubleListNode head = new DoubleListNode(-1);
        DoubleListNode tail = head;
        DoubleListNode p;
        for (char c : t1) {
            if (pos[c - 65] == null) {
                p = new DoubleListNode(-1);
                pos[c - 65] = p;
                p.prev = tail;
                tail.next = p;
                tail = p;
            }
        }

        // 遍历S，对每个字母，把它之前在链表里的节点删掉，在最后插入一个新节点
        for (int i = 0; i < lens; i++) {
            if (pos[s1[i] - 65] != null) {
                // 尾部接上新节点
                p = new DoubleListNode(i);
                p.prev = tail;
                tail.next = p;
                tail = tail.next;

                // 删除原来节点
                pos[s1[i] - 65].prev.next = pos[s1[i] - 65].next;
                pos[s1[i] - 65].next.prev = pos[s1[i] - 65].prev;
                pos[s1[i] - 65] = p;

                // 判断一下现在是不是最短了
                if (head.next.val != -1 && tail.val - head.next.val < end - begin) {
                    begin = head.next.val;
                    end = tail.val;
                }
            }
        }
        if (begin == -1) {
            return "";
        } else {
            return s.substring(begin, end + 1);
        }
    }

    public static void main(String[] args) {
        String S = "asadwq", T = "aa";
        System.out.println(new Problem76().minWindow(S, T));
    }
}
