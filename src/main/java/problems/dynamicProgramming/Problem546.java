package problems.dynamicProgramming;

/**
 * 546. 移除盒子
 * @author Chen Runwen
 * @difficulty H HHH
 * @status AC 91% 47%
 * @time 2020/8/15 16:56
 */
public class Problem546 {
    /** 答案的解法，很妖的动规 O(N4),O(N3) 12% 15% */
    public int removeBoxes1(int[] boxes) {
        int n = boxes.length;
        if (n <= 1) return n;
        // dp[l][r][k]表示：消除从a[l]-a[r]这一段，加上后续k个跟a[r]相等的值，能够得到的最大分数
        int[][][] dp = new int[n][n][n];
        
        for (int l = 0; l < n; l++)
            for (int k = 0; k < n - l; k++)
                dp[l][l][k] = (k + 1) * (k + 1);

        for (int l = n - 2; l >= 0; l--) {
            for (int r = l + 1; r < n; r++) {
                for (int k = 0; k < n - r; k++) {
                    if (boxes[r-1] == boxes[r]) {
                        dp[l][r][k] = dp[l][r-1][k+1];
                    } else {
                        dp[l][r][k] = dp[l][r-1][0] + (k + 1) * (k + 1);
                        for (int i = l; i < r - 1; i++)
                            if (boxes[i] == boxes[r])
                                dp[l][r][k] = Math.max(dp[l][r][k], dp[l][i][k + 1] + dp[i + 1][r - 1][0]);
                    }
                }
            }
        }

        return dp[0][n-1][0];
    }

    /** 由于动规中大部分格子都用不到，可以改成记忆化的递归 O(N4),O(N3) 91% 47% */
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        if (n <= 1) return n;
        // dp[l][r][k]表示：消除从a[l]-a[r]这一段，加上后续k个跟a[r]相等的值，能够得到的最大分数
        int[][][] dp = new int[n][n][n];

        return calc(boxes, dp, 0, n-1, 0);
    }

    private int calc(int[] boxes, int[][][] dp, int l, int r, int k) {
        if (l == r) return (k + 1) * (k + 1);
        if (dp[l][r][k] > 0) return dp[l][r][k];

        if (boxes[r-1] == boxes[r]) {
            dp[l][r][k] = calc(boxes, dp, l, r-1, k+1);
        } else {
            dp[l][r][k] = calc(boxes, dp, l, r-1, 0) + (k + 1) * (k + 1);
            for (int i = l; i < r - 1; i++)
                if (boxes[i] == boxes[r])
                    dp[l][r][k] = Math.max(dp[l][r][k], calc(boxes, dp, l, i, k+1) + calc(boxes, dp, i+1, r-1, 0));
        }
        return dp[l][r][k];
    }

    public static void main(String[] args) {
        int[] boxes = new int[]{1,3,2,2,2,3,4,3,1};
        System.out.println(new Problem546().removeBoxes(boxes));
    }
}
