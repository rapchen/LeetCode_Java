package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 13%
 * @time 2020/7/4 23:12
 */
public class Problem18 {
    /** 排序N3，加一些剪枝 */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length, l;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target) continue;
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) break;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                if (nums[i] + nums[j] + nums[len-2] + nums[len-1] < target) continue;
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                l = len - 1;
                for (int k = j + 1; k < len - 1; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) continue;
                    while (nums[i] + nums[j] + nums[k] + nums[l] > target && l > k) l--;
                    if (l <= k) break;
                    if (nums[i] + nums[j] + nums[k] + nums[l] == target)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(new Problem18().fourSum(nums, target));
    }
}
