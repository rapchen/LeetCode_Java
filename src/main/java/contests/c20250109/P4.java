package contests.c20250109;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Q4. 最多 K 个元素的子数组的最值之和
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public long minMaxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        // 存每个可以是max（大于右边所有）的下标
        Deque<Integer> maxs = new ArrayDeque<>();
        Deque<Long> sums = new ArrayDeque<>();  // 不考虑左边
        Deque<Integer> mins = new ArrayDeque<>();
        Deque<Long> sums2 = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - k + 1); // 最左边
            while (!maxs.isEmpty() && nums[i] >= nums[maxs.getLast()]) {
                maxs.removeLast();
                sums.removeLast();
            }
            if (!maxs.isEmpty() && maxs.getFirst() < left) {
                maxs.removeFirst();
                sums.removeFirst();
            }
            // 考虑左边
            long sum = maxs.isEmpty() ? (long) nums[i] * (i-left+1) :
                    (long) nums[i] * (i - maxs.getLast()) + sums.getLast()
                            - sums.getFirst() + (long) nums[maxs.getFirst()] * (maxs.getFirst() - left + 1);
            maxs.addLast(i);
            sums.addLast(sum);
            res += sum;

            while (!mins.isEmpty() && nums[i] <= nums[mins.getLast()]) {
                mins.removeLast();
                sums2.removeLast();
            }
            sum = mins.isEmpty() ? (long) nums[i] * (i+1) : (long) nums[i] * (i - mins.getLast()) + sums2.getLast();
            mins.addLast(i);
            sums2.addLast(sum);
            res += sum;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int k = 2;
        System.out.println(new P4().minMaxSubarraySum(nums, k));
    }
}
