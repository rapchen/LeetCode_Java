package contests.c20240818;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public long minimumOperations(int[] nums, int[] target) {
        int n = nums.length;
        int[] sub = new int[n];
        for (int i = 0; i < n; i++) {
            sub[i] = target[i] - nums[i];
        }
//        int[] gap = new int[n+1];
//        gap[0] = sub[0];
//        gap[n] = -sub[n-1];
//        for (int i = 1; i < n; i++) {
//            gap[i] = sub[i] - sub[i-1];
//        }

        long ans = 0;
        if (sub[0] > 0) ans += sub[0];
        if (sub[n-1] < 0) ans -= sub[n-1];
        for (int i = 1; i < n; i++) {
            int gap = sub[i] - sub[i-1];
            if (gap > 0) ans += gap;
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i = -1; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
