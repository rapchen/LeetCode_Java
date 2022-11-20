package contests.c20221113;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/13 10:27
 */
public class P4 {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] c = new char[n];
        s.getChars(0, n, c, 0);
        int[] dp = new int[n+1];  // 前i个字符里能切出的最大
        // 找回文
        int[] pal = new int[n];  // 以第i个字符结尾的最短回文串长度（需要>=k）
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - j < 0 || i + j >= n || c[i-j] != c[i+j]) break;
                int tmp = j*2+1;
                if (tmp >= k && (pal[i+j] == 0 || tmp < pal[i+j]))
                    pal[i+j] = tmp;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (i - j + 1 < 0 || i + j >= n || c[i-j+1] != c[i+j]) break;
                int tmp = j*2;
                if (tmp >= k && (pal[i+j] == 0 || tmp < pal[i+j]))
                    pal[i+j] = tmp;
            }
        }

        // dp
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i-1];
            if (pal[i-1] > 0)
                dp[i] = Math.max(dp[i], dp[i-pal[i-1]] + 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "abaccdbbd";
        int k = 3;
        System.out.println(new P4().maxPalindromes(s, k));
    }
}
