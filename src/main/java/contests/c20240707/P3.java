package contests.c20240707;

import java.util.Arrays;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sub = new int[m+1][n+1];  // x比y多
        boolean[][] hasX = new boolean[m+1][n+1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sub[i][j] = sub[i-1][j] + sub[i][j-1] - sub[i-1][j-1] +
                        (grid[i-1][j-1] == 'X' ? 1 : grid[i-1][j-1] == 'Y' ? -1 : 0);
                hasX[i][j] = hasX[i-1][j] || hasX[i][j-1] || grid[i-1][j-1] == 'X';
                if (sub[i][j] == 0 && hasX[i][j]) res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
//        int seats =5;
//        System.out.println(new P3().maxTotalReward(roads, seats));
    }
}
