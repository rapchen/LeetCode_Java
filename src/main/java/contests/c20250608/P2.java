package contests.c20250608;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int zero = complexity[0];
        for (int j = 1; j < complexity.length; j++) {
            int i = complexity[j];
            if (i <= zero) return 0;
        }
        // n-1 !
        long res = 1;
        for (int i = 1; i < n; i++) {
            res = (res * i) % 1000000007;
        }
        return (int) res;
    }
}
