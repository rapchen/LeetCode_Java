package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * @author Chen Runwen
 * @difficulty M
 * @status AC
 * @time 2020/6/30 23:06 - 23:33
 */
public class Problem15 {
    /** 排序N2，69% 99% */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length, k;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            k = len - 1;
            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while (nums[i] + nums[j] + nums[k] > 0 && k > j) k--;
                if (k <= j) break;
                if (nums[i] + nums[j] + nums[k] == 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
        return res;
    }

    /** 改了下更差了 28% 98% */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length, k, sum;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            k = len - 1;
            for (int j = i + 1; j < len - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                while ((sum = nums[i] + nums[j] + nums[k]) > 0 && k > j) k--;
                if (k <= j) break;
                if (sum == 0)
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(new Problem15().threeSum(nums));
    }
}
