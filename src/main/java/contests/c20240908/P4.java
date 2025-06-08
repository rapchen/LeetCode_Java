package contests.c20240908;

import java.util.*;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public int maxMoves(int kx, int ky, int[][] positions) {
        int n = positions.length;
        int[][] steps = new int[n+1][n+1];  // 第n个点是kx,ky
        for (int i = 0; i < n + 1; i++) {  // 从i出发
            for (int j = 0; j < n + 1; j++) {  // 到j
                // TODO: 2024-09-08 可以少一半
                int x0 = i == n ? kx : positions[i][0];
                int y0 = i == n ? ky : positions[i][1];
                int x1 = j == n ? kx : positions[j][0];
                int y1 = j == n ? ky : positions[j][1];
                steps[i][j] = calcHorse(x0, y0, x1, y1);
            }
        }

        int space = 1 << n;  // 空间大小
        int[][] a = new int[space][n+1], b = new int[space][n+1];
        for (int s = 1; s < space; s++) {  // s = 0，不用跳，直接0
            for (int j = 0; j < n + 1; j++) {  // 从第j兵开始，后续要遍历space
                List<Integer> bits = getBits(s);
                a[s][j] = 0;
                b[s][j] = Integer.MAX_VALUE;
                for (Integer k : bits) {  // 跳到第k兵，space里扣掉第k兵
                    a[s][j] = Math.max(a[s][j], steps[j][k] + b[s - (1 << k)][k]);
                    b[s][j] = Math.min(b[s][j], steps[j][k] + a[s - (1 << k)][k]);
                }
            }
        }
        return a[space-1][n];
    }

    private List<Integer> getBits(int num) {
        int k = 0;
        List<Integer> res = new ArrayList<>();
        while (num > 0) {
            if (num % 2 == 1) res.add(k);
            num /= 2;
            k++;
        }
        return res;
    }

    /**
     * <a href="https://zhuanlan.zhihu.com/p/581964941">原文</a>
     */
    private int calcHorse(int x0, int y0, int x1, int y1) {
        if (x0 == x1 && y0 == y1) return 0;
        int dx = Math.abs(x0 - x1);
        int dy = Math.abs(y0 - y1);
        int a = Math.max(dx, dy);
        int b = Math.min(dx, dy);
        if (a <= 4) return bfs(x0, y0, x1, y1);
        if (a >= 2 * b) {
            a -= 2 * b;
            return b + (a / 4) * 2 + a % 4;
        }
        return (a + b) / 3 + (a + b) % 3;
    }

    private static final int[][] HORSE = new int[][]{
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    private int bfs(int x0, int y0, int x1, int y1) {
        if (x0 == x1 && y0 == y1) return 0;
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(List.of(x0, y0, 0));
        Set<List<Integer>> used = new HashSet<>();
        used.add(List.of(x0, y0));
        while (!q.isEmpty()) {
            List<Integer> from = q.poll();
            for (int[] dir : HORSE) {
                int x2 = from.get(0) + dir[0];
                int y2 = from.get(1) + dir[1];
                if (x2 < 0 || x2 >= 50 || y2 < 0 || y2 >= 50) continue;
                List<Integer> to = List.of(x2, y2);
                if (used.contains(to)) continue;

                int step = from.get(2);
                if (x2 == x1 && y2 == y1) return step + 1;
                q.add(List.of(x2, y2, step + 1));
                used.add(List.of(x2, y2));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int kx = 0;
        int ky = 2;
        int[][] positions = new int[][]{{1,1},{2,2},{3,3}};
        System.out.println(new P4().maxMoves(kx, ky, positions));
    }
}
