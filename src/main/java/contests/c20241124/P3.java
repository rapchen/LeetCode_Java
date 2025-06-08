package contests.c20241124;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int[][] dp = new int[op1+1][op2+1];  // 执行次
        for (int num : nums) {
            dp[0][0] += num;
        }
        for (int i = 0; i <= op1; i++) {
            for (int j = 0; j <= op2; j++) {
                dp[i][j] = dp[0][0];
            }
        }
        for (int num : nums) {  // 处理第i个数
            int[][] newdp = new int[op1+1][op2+1];
            int sub1 = num - (num + 1) / 2;
            int sub2 = num >= k ? k : 0;
            int sub3 = (num + 1) / 2 >= k ? (num - ((num + 1) / 2 - k)) :
                    num >= k ? num - ((num - k + 1) / 2) : 0;
            for (int i = 0; i <= op1; i++) {
                for (int j = 0; j <= op2; j++) {
                    int tmp = dp[i][j];
                    if (i > 0) tmp = Math.min(tmp, dp[i-1][j] - sub1);
                    if (j > 0) tmp = Math.min(tmp, dp[i][j-1] - sub2);
                    if (i > 0 && j > 0) tmp = Math.min(tmp, dp[i-1][j-1] - sub3);
                    newdp[i][j] = tmp;
                }
            }
            dp = newdp;
        }
        return dp[op1][op2];
    }

    public static void main(String[] args) {

    }
}