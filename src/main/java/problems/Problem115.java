package problems;

/**
 * 115. Distinct Subsequences
 * @author Chen Runwen
 * @time 2019/11/3 1:17
 */
public class Problem115 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return 0;
        }
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        // f(i,j) = t的前i个字符在s的前j个字符中有几种出现方式
        // f(0, j) = 1
        // f(i, i-1) = 0
        // f(i, j) = f(i, j-1) + (t[i-1]=s[j-1] ? f(i-1, j-1) : 0)
        int[] dp = new int[len1 + 1];
        int leftTop, tmp; // 用来存f(i-1,j-1)
        for (int j = 0; j <= len1; j++) {
            dp[j] = 1;
//            System.out.printf("%d ", dp[j]);
        }
//        System.out.print('\n');

        for (int i = 1; i <= len2; i++) {
            leftTop = dp[i - 1];
            dp[i - 1] = 0;
            for (int j = i; j <= len1; j++) {
                tmp = leftTop;
                leftTop = dp[j];
                dp[j] = dp[j - 1] + (chars2[i - 1] == chars1[j - 1] ? tmp : 0);
            }

//            for (int j = 0; j <= len1; j++) {
//                System.out.printf("%d ", dp[j]);
//            }
//            System.out.print('\n');

        }
        return dp[len1];
    }

    public static void main(String[] args) {
        String S = "babgbag", T = "bag";
        System.out.println(new Problem115().numDistinct(S, T));
    }

}
