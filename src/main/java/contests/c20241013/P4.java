package contests.c20241013;

import java.util.*;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return num == pair.num && cnt == pair.cnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(num, cnt);
        }
    }

//    public long[] findXSum(int[] nums, int k, int x) {
//        int n = nums.length;
//        // num, cnt
//        Map<Integer, Integer> cnts = new HashMap<>();
//        // <num, cnt>, 先cnt后num排序，倒序
//        TreeSet<Pair> pairs = new TreeSet<>((a, b) -> a.cnt - b.cnt != 0 ? b.cnt - a.cnt : b.num - a.num);
//        long[] res = new long[n-k+1];
//        long sum = 0;
//        Pair xth = null;
//
//        // init
//        for (int i = 0; i < k; i++) {
//            int num = nums[i];
//            cnts.compute(num, (nu, cn) -> cn == null ? 1 : cn+1);
//        }
//        cnts.forEach((nu, cn) -> pairs.add(new Pair(nu, cn)));
//        int tmp = 0;
//        for (Iterator<Pair> iterator = pairs.iterator(); iterator.hasNext(); ) {
//            Pair pair = iterator.next();
//            sum += pair.cnt * pair.num;
//            tmp ++;
//            if (tmp==x) {
//                xth = pair;
//                break;
//            }
//        }
//        res[0] = sum;
//
//        for (int i = k; i < n; i++) {
//            int num = nums[i];
//            int cnt = cnts.get(num);
//            Pair pair = new Pair(num, cnt);
//            int left = nums[i-k];
//            int lcnt = cnts.get(left);
//
////            if ()
//
//            res[i-k+1] = sum;
//        }
//    }

    public static void main(String[] args) {
        int kx = 0;
        int ky = 2;
        int[][] positions = new int[][]{{1,1},{2,2},{3,3}};
//        System.out.println(new P4().maxMoves(kx, ky, positions));
    }
}
