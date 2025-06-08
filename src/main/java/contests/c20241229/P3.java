package contests.c20241229;

import java.util.*;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public long numberOfSubsequences(int[] nums) {
        long res = 0;
        int n = nums.length;
        Map<Pair, Set<Pair>> left = new HashMap<>();
        Map<Pair, Set<Pair>> right = new HashMap<>();

        for (int r = 4; r <= n-3; r++) {
            for (int s = r+2; s < n; s++) {
                Pair key = div(nums[s], nums[r]);
                right.computeIfAbsent(key, k -> new HashSet<>()).add(new Pair(s, r));
            }
        }

        // i 中间
        for (int i = 3; i < n - 3; i++) {
            int q = i -1;
            int r = i;
            left.clear();
            for (int p = 0; p < q - 1; p++) {
                Pair key = div(nums[p], nums[q]);
                left.computeIfAbsent(key, k -> new HashSet<>()).add(new Pair(p, q));
            }
            for (int s = r+2; s < n; s++) {
                Pair key = div(nums[s], nums[r]);
                right.computeIfAbsent(key, k -> new HashSet<>()).remove(new Pair(s, r));
            }
            for (Map.Entry<Pair, Set<Pair>> entry : left.entrySet()) {
                Pair value = entry.getKey();
                Set<Pair> leftSet = entry.getValue();
                Set<Pair> rightSet = right.get(value);
                if (rightSet != null) {
                    res += (long) leftSet.size() * rightSet.size();
                }
            }
        }
        return res;
    }

    private Pair div(int a, int b) {
        int c =a,d=b;
        while (d != 0) {
            int tmp = c % d;
            c = d;
            d = tmp;
        }
        return new Pair(a / c, b / c);
    }

    public static void main(String[] args) {

    }
}