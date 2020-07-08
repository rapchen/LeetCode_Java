package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 5%
 * @time 2020/7/8 23:09 - 23:18
 */
public class Problem78 {
    /** 99% 5% */
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set;
        for (int i = 0; i < (int) Math.pow(2, len); i++) {
            set = new ArrayList<>();
            for (int j = 0; j < len; j++)
                if ((i >> j & 1) == 1) set.add(nums[j]);
            res.add(set);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,15,7};
        System.out.println(new Problem78().subsets(nums));
    }
}
