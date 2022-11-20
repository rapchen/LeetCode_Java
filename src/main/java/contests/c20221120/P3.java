package contests.c20221120;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    static class TNode {
        long oil=0;  // 到这里需要的油量
        int bus=0;  // 目前使用的车数
        int seat=1;  // 已用的空位
        HashSet<Integer> sons = new HashSet<>();
        TNode() {}
    }

    TNode[] nodes;
    int seats;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        nodes = new TNode[n];
        this.seats = seats;
        for (int i = 0; i < n; i++) {
            nodes[i] = new TNode();
        }
        for (int[] road : roads) {
            nodes[road[0]].sons.add(road[1]);
            nodes[road[1]].sons.add(road[0]);
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        while (!deque.isEmpty()) {
            int p = deque.pollFirst();
            for (Integer son : nodes[p].sons) {
                nodes[son].sons.remove(p);
                deque.push(son);
            }
        }
        calc(nodes[0]);
        return nodes[0].oil;
    }

    private void calc(TNode node) {
        for (Integer son : node.sons) {
            TNode nson = nodes[son];
            calc(nson);
            node.bus += nson.bus;
            node.seat += nson.seat;
            node.oil += nson.oil + nson.bus;
        }
        node.bus = (node.seat - 1) / seats + 1;
//        if (node.bus*seats < node.seat) node.bus++;
    }

    public static void main(String[] args) {
        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
        int seats =5;
        System.out.println(new P3().minimumFuelCost(roads, seats));
    }
}
