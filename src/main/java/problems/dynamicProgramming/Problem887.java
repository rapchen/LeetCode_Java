package problems.dynamicProgramming;

/**
 * 887. 鸡蛋掉落
 * @author Chen Runwen
 * @difficulty H
 * @status TODO
 * @time 2020/9/21 0:27
 */
public class Problem887 {
    /** 动规，计算i个蛋砸j次的最大层数 */
    public int superEggDrop(int K, int N) {
        if (K == 1) return N;

        // dp[i][j]: i个蛋砸j次的最大层数 TODO
        int[][] dp;
        return 0;
    }

    public static void main(String[] args) {
        int K = 1, N = 2;
        System.out.println(new Problem887().superEggDrop(K, N));
    }
}
