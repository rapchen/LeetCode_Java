package problems.dynamicProgramming;

/**
 * 64. 最小路径和
 * @author Chen Runwen
 * @difficulty M
 * @status AC 98% 25%
 * @time 2020/7/23 22:33
 */
public class Problem64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int j = 1; j < n; j++) dp[j] = dp[j - 1] + grid[0][j];
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
        }
        return dp[n - 1];
    }
}
