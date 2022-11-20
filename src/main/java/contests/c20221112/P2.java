package contests.c20221112;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/12 22:52
 */
public class P2 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        int ans = 0;
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            dp[i] = 0;
            if (i - zero >= 0) dp[i] += dp[i-zero];
            if (i - one >= 0) dp[i] = (dp[i] + dp[i-one]) % 1000000007;
            if (i >= low) ans = (ans + dp[i]) % 1000000007;
        }
        return ans;
    }
}
