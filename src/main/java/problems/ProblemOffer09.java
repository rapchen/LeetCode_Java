package problems;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * @author Chen Runwen
 * @difficulty E
 * @status AC 92% 100%
 * @time 2020/6/30 22:51 - 23:06
 */
public class ProblemOffer09 {
    class CQueue {
        Deque<Integer> head; // 表示队列的前半部分
        Deque<Integer> tail; // 表示队列的后半部分

        public CQueue() {
            head = new ArrayDeque<>();
            tail = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            tail.addLast(value);
        }

        public int deleteHead() {
            if (head.size() > 0)
                return head.removeLast();
            else if (tail.size() == 0)
                return -1;
            else {
                while (tail.size() > 0) {
                    head.addLast(tail.removeLast());
                }
                return head.removeLast();
            }
        }
    }

    public static void main(String[] args) {

    }
}
