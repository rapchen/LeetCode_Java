package contests.c20241124;

import structs.TreeNode;

import java.util.*;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int m = n / k;
        Map<String, Integer> subCount = new HashMap<>();
        for (int i = 0; i < k; i++) {
            String sub = s.substring(i*m, (i+1) * m);
            subCount.compute(sub, (key,v) -> v == null ? 1 : v + 1);
        }
        for (int i = 0; i < k; i++) {
            String sub = t.substring(i*m, (i+1) * m);
            subCount.compute(sub, (key,v) -> v == null ? -1 : v - 1);
        }
        for (Integer value : subCount.values()) {
            if (value != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1000000000,0};
        int d = 1000000000;
//        System.out.println(new P2().maxPossibleScore(start, d));
    }
}
