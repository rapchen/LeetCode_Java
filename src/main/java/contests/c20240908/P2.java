package contests.c20240908;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        Arrays.sort(start);
        int hi = (start[n-1] + d - start[0]) / (n - 1) + 1;  // 一个上界，完美分割
        int lo = 0; // [lo, hi)
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (possible(start, d, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean possible(int[] start, int d, int sub) {
        int num = start[0];
        for (int i = 1; i < start.length; i++) {
            num += sub;
            if (num > start[i] + d) return false;
            if (num < start[i]) num = start[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1000000000,0};
        int d = 1000000000;
        System.out.println(new P2().maxPossibleScore(start, d));
    }
}
