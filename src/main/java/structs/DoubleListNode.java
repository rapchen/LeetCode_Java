package structs;

/**
 * 双向链表的节点
 * @author Chen Runwen
 * @time 2020/4/9 0:28
 */
public class DoubleListNode {
    public int val;
    public DoubleListNode prev;
    public DoubleListNode next;

    public DoubleListNode(int x) {
        val = x;
    }
}
