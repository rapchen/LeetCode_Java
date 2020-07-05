package problems;

/**
 * 718. 最长重复子数组
 * @author Chen Runwen
 * @difficulty M
 * @status AC 80% 100%
 * @time 2020/7/1 22:36
 */
public class Problem718 {
    /** 动规 O(MN) O(N) 80% 100% */
    public int findLength(int[] A, int[] B) {
        int lenA = A.length, lenB = B.length, res = 0;
        int[] dp = new int[lenB]; // 代表以A[i]和B[j]为结尾的字符串尾部重复了几个数字
        for (int i = 0; i < lenA; i++) {
            for (int j = lenB - 1; j >= 1; j--) {
                dp[j] = A[i] == B[j] ? dp[j - 1] + 1 : 0;
                if (dp[j] > res) res = dp[j];
            }
            dp[0] = A[i] == B[0] ? 1 : 0;
            if (dp[0] > res) res = dp[0];
        }
        return res;
    }

    /** TODO 二分查找 */

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 2, 1};
        int[] B = new int[]{3, 2, 1, 4, 7};
        System.out.println(new Problem718().findLength(A, B));
    }
}
