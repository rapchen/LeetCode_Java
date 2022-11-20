package contests.c20221106;

import java.util.PriorityQueue;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/6 11:12
 */
public class P3 {
    class Worker implements Comparable<Worker> {
        int cost;
        int idx;
        int pos; // 1前，2后

        public Worker(int cost, int idx, int pos) {
            this.cost = cost;
            this.idx = idx;
            this.pos = pos;
        }

        @Override
        public int compareTo(Worker o) {
            if (cost < o.cost) return -1;
            else if (cost > o.cost) return 1;
            return idx - o.idx;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Worker> pq = new PriorityQueue<>();
        int left = candidates, right = Math.max(candidates - 1, costs.length - candidates - 1);
        for (int i = 0; i < candidates; i++) {
            pq.add(new Worker(costs[i], i, 1));
        }
        for (int i = costs.length - 1; i > right; i--) {
            pq.add(new Worker(costs[i], i, 2));
        }
        long ans = 0;
        for (int j = 0; j < k; j++) {
            Worker w = pq.poll();
            ans += w.cost;
            if (right >= left) {
                if (w.pos == 1) {
                    pq.add(new Worker(costs[left], left, 1));
                    left ++;
                } else {
                    pq.add(new Worker(costs[right], left, 2));
                    right --;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] costs = {31,25,72,79,74,65,84,91,18,59,27,9,81,33,17,58};
        int k = 11;
        int candidates = 2;
        System.out.println(new P3().totalCost(costs, k, candidates));
    }
}
