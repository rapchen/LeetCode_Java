package problems;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * @author Chen Runwen
 * @difficulty M
 * @status AC 85% 6%
 * @time 2020/6/30 23:35
 */
public class Problem16 {
    /** 排序,N2，85% 6% */
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int len = nums.length, k, diff;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            k = len - 1;
            for (int j = i + 1; j < len - 1; j++) {
                while (k > j) {
                    diff = nums[i] + nums[j] + nums[k] - target;
                    if (Math.abs(diff) < Math.abs(minDiff)) {
                        if (diff == 0) return target;
                        minDiff = diff;
                    }
                    if (diff > 0) k--; else break;
                }
                if (k <= j) break;
            }
        }
        return target + minDiff;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        int target = 1;
        System.out.println(new Problem16().threeSumClosest(nums, target));
    }
}
