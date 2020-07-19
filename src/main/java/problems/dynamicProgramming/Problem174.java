package problems.dynamicProgramming;

/**
 * 174. 地下城游戏
 * @author Chen Runwen
 * @difficulty H
 * @status AC 96% 100%
 * @time 2020/7/12 21:20 - 21:38
 */
public class Problem174 {
    /** 朴素的动规 */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n];
        dp[n - 1] = 1 - Math.min(dungeon[m - 1][n - 1], 0);
        for (int j = n - 2; j >= 0; j--)
            dp[j] = Math.max(dp[j + 1] - dungeon[m - 1][j], 1);
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(dp[n - 1] - dungeon[i][n - 1], 1);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(Math.min(dp[j + 1], dp[j]) - dungeon[i][j], 1);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][] {
                {-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}
        };
        System.out.println(new Problem174().calculateMinimumHP(dungeon));
    }
}
