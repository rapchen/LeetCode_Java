package problems.dynamicProgramming;

/**
 * 97. Interleaving String
 * @author Chen Runwen
 * @difficulty H
 * @status AC 90% 14%
 * @time 2019/11/3 0:50
 */
public class Problem97 {
    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3) {
            return false;
        }

        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        char[] cs3 = s3.toCharArray();

        // dp[j]表示s1前i个字符和s2前j个字符能否组成s3前i+j个字符
        boolean[] dp = new boolean[len2 + 1];
        // 先算i=0的情况
        dp[0] = true;
        for (int j = 1; j < len2 + 1; j++) {
            dp[j] = dp[j - 1] && (cs2[j - 1] == cs3[j - 1]);
        }
        // 迭代
        for (int i = 1; i < len1 + 1; i++) {
            dp[0] = dp[0] && (cs1[i - 1] == cs3[i - 1]);
            for (int j = 1; j < len2 + 1; j++) {
                dp[j] = (dp[j] && (cs1[i - 1] == cs3[i + j - 1])) || (dp[j - 1] && (cs2[j - 1] == cs3[i + j - 1]));
            }
        }
        return dp[len2];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), len3 = s3.length(), i, j;
        if (len1 + len2 != len3) return false;
        if (len1 == 0) return s2.equals(s3);
        if (len2 == 0) return s1.equals(s3);

        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        boolean[] dp = new boolean[len2 + 1];  // s1的前i个和s2的前j个可以拼成s3的前i+j个字符
        dp[0] = true;
        for (j = 1; j <= len2; j++) {
            if (c2[j - 1] != c3[j - 1]) break;
            dp[j] = true;
        }
        for (i = 1; i <= len1; i++) {
            dp[0] = dp[0] && (c1[i - 1] == c3[i - 1]);
            for (j = 1; j <= len2; j++)
                dp[j] = (dp[j - 1] && (c2[j - 1] == c3[i + j - 1])) ||
                        (dp[j] && (c1[i - 1] == c3[i + j - 1]));
        }
        return dp[len2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(new Problem97().isInterleave(s1, s2, s3));
    }

}
