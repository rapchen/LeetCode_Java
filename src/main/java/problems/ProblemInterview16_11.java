package problems;

/**
 * 面试题 16.11. 跳水板
 * @author Chen Runwen
 * @difficulty E
 * @status AC 96% 100%
 * @time 2020/7/8 22:45 - 22:50
 */
public class ProblemInterview16_11 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{shorter * k};
        int[] res = new int[k+1];
        int sub = longer - shorter;
        res[0] = shorter * k;
        for (int i = 1; i <= k; i++)
            res[i] = res[i - 1] + sub;
        return res;
    }

}
