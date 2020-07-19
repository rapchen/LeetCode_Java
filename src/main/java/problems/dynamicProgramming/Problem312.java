package problems.dynamicProgramming;

/**
 * 312. 戳气球
 * @author Chen Runwen
 * @difficulty H
 * @status AC 94% 25%
 * @time 2020/7/19 16:50
 */
public class Problem312 {
    /** 动规，时间O(N3)，空间O(N2) */
    public int maxCoins1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // coin[i][j]代表在i-1和j都未消除的情况下，消除[i,j)区间中的所有气球所能得到的最大金币数。
        int[][] coin = new int[n + 1][n + 1];
        int leftRight;

        // 先计算长度为1的区间[i,i+1)
        coin[0][1] = nums[0] * nums[1];
        coin[n-1][n] = nums[n-2] * nums[n-1];
        for (int i = 1; i < n-1; i++) coin[i][i+1] = nums[i - 1] * nums[i] * nums[i + 1];

        // 按区间长度m从短到长遍历所有区间
        for (int m = 2; m <= n; m++) {
            // i为区间的左端点，即区间为[i,i+m)
            for (int i = 0; i <= n - m; i++) {
                leftRight = (i == 0 ? 1 : nums[i - 1]) * (i + m == n ? 1 : nums[i + m]);
                // 遍历当前区间中所有气球，计算最后一个消除该气球能得到的最大金币数，然后更新结果
                for (int k = i; k < i + m; k++) {
                    coin[i][i+m] = Math.max(coin[i][i+m], leftRight * nums[k] + coin[i][k] + coin[k+1][i+m]);
                }
            }
        }
        return coin[0][n];
    }

    /** 简单优化下：用新数组记录nums[-1]和nums[n]，避免判断 没啥变化 */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // coin[i][j]代表在i-1和j都未消除的情况下，消除[i,j)区间中的所有气球所能得到的最大金币数。
        int[][] coin = new int[n + 1][n + 1];
        int[] val = new int[n + 2];
        System.arraycopy(nums, 0, val, 1, n);
        val[0] = val[n + 1] = 1;
        int leftRight;

        // 先计算长度为1的区间[i,i+1)
        for (int i = 0; i < n; i++) coin[i][i+1] = val[i] * val[i+1] * val[i+2];

        // 按区间长度m从短到长遍历所有区间
        for (int m = 2; m <= n; m++) {
            // i为区间的左端点，即区间为[i,i+m)
            for (int i = 0; i <= n - m; i++) {
                leftRight = val[i] * val[i+m+1];
                // 遍历当前区间中所有气球，计算最后一个消除该气球能得到的最大金币数，然后更新结果
                for (int k = i; k < i + m; k++) {
                    coin[i][i+m] = Math.max(coin[i][i+m], leftRight * val[k+1] + coin[i][k] + coin[k+1][i+m]);
                }
            }
        }
        return coin[0][n];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,1,5,8};
        System.out.println(new Problem312().maxCoins(nums));
    }
}
