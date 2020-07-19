package problems.dynamicProgramming;

/**
 * 44. Wildcard Matching
 * @author Chen Runwen
 * @difficulty H
 * @status AC 80% 53%
 * @time 2019/11/3 16:08
 */
public class Problem44 {
    /**
     * 最初的做法，简单的DP TODO 似乎有更快的写法
     */
    public boolean isMatch1(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        if (len2 == 0) {
            return len1 == 0;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();

        // f(i,j) = p的前i个字符能否匹配s的前j个字符
        // f(0, 0) = True  f(0, j) = False
        boolean[] dp = new boolean[len1 + 1];
        boolean leftTop, tmp;

        dp[0] = true;
        for (int j = 1; j <= len1; j++) {
            dp[j] = false;
        }

        for (int j = 0; j <= len1; j++) {
            System.out.printf("%s ", dp[j] ? 'T' : 'F');
        }
        System.out.print('\n');

        for (int i = 1; i <= len2; i++) {
            if (chars2[i - 1] == '*') {
                // * 的情况，f(i, j) = f(i-1, j) || f(i, j-1)
                for (int j = 1; j <= len1; j++) {
                    dp[j] = dp[j] || dp[j - 1];
                }
            } else if (chars2[i - 1] == '?') {
                // ? 的情况，f(i, j) = f(i-1, j-1)
                leftTop = dp[0];
                dp[0] = false;
                for (int j = 1; j <= len1; j++) {
                    tmp = leftTop;
                    leftTop = dp[j];
                    dp[j] = tmp;
                }
            } else {
                // a 的情况，f(i, j) = f(i-1, j-1) && p[i-1] == s[j-1]
                leftTop = dp[0];
                dp[0] = false;
                for (int j = 1; j <= len1; j++) {
                    tmp = leftTop;
                    leftTop = dp[j];
                    dp[j] = tmp && chars2[i - 1] == chars1[j - 1];
                }
            }

            for (int j = 0; j <= len1; j++) {
                System.out.printf("%s ", dp[j] ? 'T' : 'F');
            }
            System.out.print('\n');

        }
        return dp[len1];
    }

    /** 简洁的动规，85% 46% */
    private boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray(), ps = p.toCharArray();
        int len = ss.length, first = 0, k;  // first: ss里第一个true
        boolean[] dp = new boolean[len + 1];  // 对应s的前i位能否被p的前j位表示
        dp[0] = true;
        for (char y : ps) {
            if (y == '*') {
                for (int i = first + 1; i <= len; i++) dp[i] = dp[i - 1] || dp[i];
                if (!dp[len]) return false;
            } else {
                if (y == '?') {
                    if(++first > len) return false;
                    for (int i = len; i >= first; i--) dp[i] = dp[i - 1];
                } else {
                    k = len + 1;
                    for (int i = len; i >= first + 1; i--) {
                        dp[i] = dp[i - 1] && ss[i - 1] == y;
                        if (dp[i]) k = i;
                    }
                    if (k > len) return false;
                    first = k;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(new Problem44().isMatch(s, p));
    }

}
