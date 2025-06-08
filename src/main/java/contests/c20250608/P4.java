package contests.c20250608;

import java.util.HashMap;
import java.util.Map;

/**
 * Q4. 移除最小数对使数组有序 II
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public int minOperations(String word1, String word2) {
        int n = word1.length();
        int[] dp = new int[n+1];  // 前i个数的操作数

        for (int i = 0; i < n; i++) {
            dp[i+1] = 1000000;
            for (int j = 0; j <= i; j++) {
                dp[i+1] = Math.min(dp[i+1], dp[j] + minOp(word1, word2, j, i));
            }
        }
        return dp[n];
    }

    private int minOp(String word1, String word2, int begin, int end) {
        Map<String, Integer> map = new HashMap<>();

        int res = 0;
        for (int i = begin; i <= end; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if (c1 == c2) continue;

            res++;
            String key = String.valueOf(c1) + String.valueOf(c2);
            String rev = String.valueOf(c2) + String.valueOf(c1);
            if (map.getOrDefault(rev, 0) > 0) {
                map.put(rev, map.get(rev) - 1);
                res --;
            } else {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int revres = 1;
        map = new HashMap<>();
        for (int i = begin; i <= end; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(end+begin-i);
            if (c1 == c2) continue;

            revres++;
            String key = String.valueOf(c1) + String.valueOf(c2);
            String rev = String.valueOf(c2) + String.valueOf(c1);
            if (map.getOrDefault(rev, 0) > 0) {
                map.put(rev, map.get(rev) - 1);
                revres --;
            } else {
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        return Math.min(res, revres);
    }

    public static void main(String[] args) {
        new P4().minOperations("abcdf", "dacbe");
    }
}
