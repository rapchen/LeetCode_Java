package contests.c20241013;

import java.util.List;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public static char[] creatures = new char[]{'F', 'E', 'W'};

    private int score(char a, char b) {
        if (a == b) return 0;
        if (a == 'F') return b == 'W' ? 1 :-1;
        if (a == 'E') return b == 'F' ? 1 :-1;
        if (a == 'W') return b == 'E' ? 1 :-1;
        return 0;
    }

    public int countWinningSequences(String s) {
        int n = s.length();
        // -n 0 n ; FEW F>E>W
        long[][] dp = new long[3][2*n+1];
        char[] chars = s.toCharArray();
        dp[0][score(chars[0], 'F') + n] += 1;
        dp[1][score(chars[0], 'E') + n] += 1;
        dp[2][score(chars[0], 'W') + n] += 1;

        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            long[][] newdp = new long[3][2*n+1];
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 2 * n + 1; k++) {
                    int score = score(c, creatures[j]);
                    if (score == 1 && k == 0) continue;
                    if (score == -1 && k == 2*n) continue;
                    for (int l = 0; l < 3; l++) {
                        if (l == j) continue;
                        newdp[j][k] = (newdp[j][k] + dp[l][k-score]) % 1000000007;
                    }
                }
            }
            dp = newdp;
        }
        long sum = 0;
        for (int i = n+1; i < 2 * n+1; i++) {
            for (int j = 0; j < 3; j++) {
                sum = (sum + dp[j][i]) % 1000000007;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {
//        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
//        int seats =5;
//        System.out.println(new P3().maxTotalReward(roads, seats));
    }
}