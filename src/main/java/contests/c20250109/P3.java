package contests.c20250109;

import java.util.*;

/**
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public long minCost(int n, int[][] cost) {
        // i 涂完第i个， j 第i个色 k 第n-i-1个色
        long[][][] dp = new long[n / 2][3][3];

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j == k) {
                    dp[0][j][k] = -1;  //不可能
                } else {
                    dp[0][j][k] = cost[0][j] + cost[n - 1][k];
                }
            }
        }

        for (int i = 1; i < n / 2; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j == k) {
                        dp[i][j][k] = -1;  //不可能
                        continue;
                    }
                    long min = Long.MAX_VALUE;
                    for (int l = 0; l < 3; l++) {
                        if (l == j) continue;
                        for (int m = 0; m < 3; m++) {
                            if (m == k || dp[i-1][l][m] == -1) continue;
                            min = Math.min(min, cost[i][j] + cost[n-i-1][k] + dp[i-1][l][m]);
                        }
                    }
                    dp[i][j][k] = min;
                }
            }
        }
        long min = Long.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (j != k && dp[n/2-1][j][k] < min)
                    min = dp[n/2-1][j][k];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] cost = {{5,8,4},{6,10,10},{0,6,9},{7,7,4}};
        System.out.println(new P3().minCost(n, cost));
    }
}