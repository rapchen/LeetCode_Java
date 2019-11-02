package problems;

/**
 * @author Chen Runwen
 * @date 1:52
 */
public class Problem10 {
    public boolean isMatch(String s, String p) {
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

//        for (int j = 0; j <= len1; j++) {
//            System.out.printf("%s ", dp[j] ? 'T' : 'F');
//        }
//        System.out.print('\n');

        for (int i = 1; i <= len2; i++) {
            if (chars2[i - 1] == '*') {
                // 当前字符是*就不处理，因为已经在处理前一个字符时考虑过了
                continue;
            }
            if (i < len2 && chars2[i] == '*') {
                if (chars2[i - 1] == '.') {
                    // .* 的情况，f(i, j) = f(i-1, j) || f(i, j-1)
                    for (int j = 1; j <= len1; j++) {
                        dp[j] = dp[j] || dp[j - 1];
                    }
                } else {
                    // a* 的情况，f(i, j) = f(i-1, j) || (f(i, j-1) && p[i-1] == s[j-1])
                    for (int j = 1; j <= len1; j++) {
                        dp[j] = dp[j] || (dp[j - 1] && chars2[i - 1] == chars1[j - 1]);
                    }
                }
            } else {
                if (chars2[i - 1] == '.') {
                    // . 的情况，f(i, j) = f(i-1, j-1)
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
            }

//            for (int j = 0; j <= len1; j++) {
//                System.out.printf("%s ", dp[j] ? 'T' : 'F');
//            }
//            System.out.print('\n');

        }
        return dp[len1];
    }

    public static void main(String[] args) {
        String s = "mississippi", p = "mis*is*p*.";
        System.out.println(new Problem10().isMatch(s, p));
    }

}
