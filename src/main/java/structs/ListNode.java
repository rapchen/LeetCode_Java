package structs;

/**
 * @author Chen Runwen
 * @time 2019/12/11 20:55
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createLinkedList(int[] values) {
        int len = values.length;
        if (len == 0) return null;
        ListNode head = new ListNode(values[0]), p = head;
        for (int i = 1; i < len; i++) {
            p.next = new ListNode(values[i]);
            p = p.next;
        }
        return head;
    }

    public static int[] getValues(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            p = p.next;
            n++;
        }
        int[] res = new int[n];
        n = 0;
        while (head != null) {
            res[n++] = head.val;
            head = head.next;
        }
        return res;
    }

    public static String valuesToString(ListNode head) {
        StringBuilder sb = new StringBuilder("List: ");
        while (head != null) {
            sb.append(head.val).append(", ");
            head = head.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode head = createLinkedList(new int[]{1, 2, 3, 4, 5, 6});
        int[] values = getValues(head);
        System.out.println(valuesToString(head));
    }
}
