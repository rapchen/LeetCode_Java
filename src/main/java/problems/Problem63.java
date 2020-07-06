package problems;

/**
 * 63. 不同路径 II
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 74%
 * @time 2020/7/6 0:25 - 0:41
 */
public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) break;
            dp[j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] == 1 && obstacleGrid[i][0] == 0 ? 1 : 0;
            for (int j = 1; j < n; j++)
                dp[j] = obstacleGrid[i][j] == 1 ? 0 : dp[j - 1] + dp[j];
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(new Problem63().uniquePathsWithObstacles(obstacleGrid));
    }
}
