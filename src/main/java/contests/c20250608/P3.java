package contests.c20250608;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        // dp[i]: 前i个数的分割数
        long[] dp = new long[n+1];
        dp[0] = 1;
        long agg = 1;  // 次数累计, 0-0. han
        int aggBegin = 0, aggEnd = 0; //dp[aggbegin], han
        Deque<Integer> maxs = new ArrayDeque<>();  // 下标
        Deque<Integer> mins = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int lastAggBegin = aggBegin;
            while (!maxs.isEmpty() && nums[maxs.peekFirst()] - nums[i] > k) {
                Integer first = maxs.pollFirst();
                aggBegin = Math.max(aggBegin, first+1);
            }
            while (!mins.isEmpty() && nums[mins.peekFirst()] - nums[i] < -k) {
                Integer first = mins.pollFirst();
                aggBegin = Math.max(aggBegin, first+1);
            }
            // 维持
            while (!maxs.isEmpty() && nums[maxs.peekLast()] < nums[i]) {
                maxs.pollLast();
            }
            maxs.addLast(i);
            while (!mins.isEmpty() && nums[mins.peekLast()] > nums[i]) {
                mins.pollLast();
            }
            mins.addLast(i);

            //dp
            for (int j = lastAggBegin; j < aggBegin; j++) {
                agg = (agg - dp[j] + 1000000007) % 1000000007;
            }
            dp[i+1] = agg % 1000000007;
            agg = (agg + dp[i+1]) % 1000000007;
        }
        return (int) (dp[n] % 1000000007);
    }

/*
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        // dp[i]: 前i个数的分割数
        long[] dp = new long[n+1];
        dp[0] = 1;
        long agg = 0;  // 次数累计
        for (int i = 0; i < n; i++) {

            int max = nums[i], min = nums[i];
            for (int j = i; j >= 0; j--) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                if (max - min > k) break;
                dp[i+1] = (dp[i+1] + dp[j]) % 1000000007;
            }
        }
        return (int) (dp[n] % 1000000007);
    }
*/

    public static void main(String[] args) {
        int[] nums = new int[]{3,3,4};
        int k = 0;
        System.out.println(new P3().countPartitions(nums, k));
    }
}