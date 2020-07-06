package algorithm.pq;

/**
 * 最小优先队列(int)
 * @author Chen Runwen
 * @time 2020/7/5 15:37
 */
public class MinPriorityQueue {
    private final int[] heap;
    public int size;

    public MinPriorityQueue(int N) {
        heap = new int[N + 1];
        size = 0;
    }

    public void insert(int value) {
        heap[++size] = value;
        swim(size);
    }

    public int deleteMin() {
        int res = heap[1];
        heap[1] = heap[size--];
        sink(1);
        return res;
    }

    public void swim(int k) {
        int tmp = heap[k];
        while (k > 1) {
            if (tmp >= heap[k / 2]) break;
            heap[k] = heap[k / 2];
            k /= 2;
        }
        heap[k] = tmp;
    }

    public void sink(int k) {
        int tmp = heap[k], j;
        while (k <= size / 2) {
            j = k * 2;
            if (j < size && heap[j] > heap[j + 1]) j += 1;
            if (tmp <= heap[j]) break;
            heap[k] = heap[j];
            k = j;
        }
        heap[k] = tmp;
    }

    public static void main(String[] args) {
        MinPriorityQueue pq = new MinPriorityQueue(10);
        for (int v : new int[]{3,65,2,4,76,34,56,0}) {
            pq.insert(v);
        }
        while (pq.size > 0)
            System.out.println(pq.deleteMin());
    }
}
