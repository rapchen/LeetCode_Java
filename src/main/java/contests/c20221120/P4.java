package contests.c20221120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public int beautifulPartitions(String s, int k, int minLength) {
        List<Integer> seps = new ArrayList<>();
        seps.add(0);
        HashSet<Character> prime = new HashSet<Character>(Arrays.asList('2', '3', '5', '7'));
        if (!prime.contains(s.charAt(0)) || prime.contains(s.charAt(s.length()-1))) return 0;
        for (int i = 1; i < s.length(); i++) {
            if (prime.contains(s.charAt(i)) && !prime.contains(s.charAt(i-1))) seps.add(i);
        }
        seps.add(s.length());
        int m = seps.size();

        int[][] dp = new int[m][k+1];  // dp[i][j]  第i个sep为结束，j个分隔的种树
        int[][] cum = new int[m][k+1];  // cum[i][j]  在第i个sep前结束（包含），j个分隔的种树
        dp[0][0] = 1;
        cum[0][0] = 1;

        for (int i = 1; i < m; i++) {
            int last = -1;
            for (int t = i; t >= 0; t--) { // 前面的sep
                if (seps.get(i) - seps.get(t) >= minLength) {
                    last = t;
                    break;
                }
            }
            for (int j = 0; j <= k; j++) {
                if (last >= 0 && j > 0) dp[i][j] = cum[last][j-1];
                cum[i][j] = (cum[i-1][j] + dp[i][j]) % 1000000007;
            }
        }
        return dp[m-1][k];
    }
}
