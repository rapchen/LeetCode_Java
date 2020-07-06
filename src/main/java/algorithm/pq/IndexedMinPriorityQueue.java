package algorithm.pq;

/**
 * 索引最小优先队列(int)
 * @author Chen Runwen
 * @time 2020/7/5 15:37
 */
public class IndexedMinPriorityQueue {
    private final int[] heap;
    private final int[] indexes;
    public int size;

    public IndexedMinPriorityQueue(int N) {
        heap = new int[N + 1];
        indexes = new int[N + 1];
        size = 0;
    }

    public void insert(int value, int index) {
        heap[++size] = value;
        indexes[size] = index;
        swim(size);
    }

    /** 返回索引 */
    public int deleteMin() {
        int res = indexes[1];
        indexes[1] = indexes[size];
        heap[1] = heap[size--];
        sink(1);
        return res;
    }

    public void swim(int k) {
        int tmp = heap[k], index = indexes[k];
        while (k > 1) {
            if (tmp >= heap[k / 2]) break;
            heap[k] = heap[k / 2];
            indexes[k] = indexes[k / 2];
            k /= 2;
        }
        heap[k] = tmp;
        indexes[k] = index;
    }

    public void sink(int k) {
        int tmp = heap[k], index = indexes[k], j;
        while (k <= size / 2) {
            j = k * 2;
            if (j < size && heap[j] > heap[j + 1]) j += 1;
            if (tmp <= heap[j]) break;
            heap[k] = heap[j];
            indexes[k] = indexes[j];
            k = j;
        }
        heap[k] = tmp;
        indexes[k] = index;
    }

    public static void main(String[] args) {
        IndexedMinPriorityQueue pq = new IndexedMinPriorityQueue(10);
        int[] values = new int[]{3, 65, 2, 4, 76, 34, 56, 0};
        for (int i = 0; i < values.length; i++) {
            int v = values[i];
            pq.insert(v, i);
        }
        while (pq.size > 0)
            System.out.println(pq.deleteMin());
    }
}
