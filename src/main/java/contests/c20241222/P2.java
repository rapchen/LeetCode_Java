package contests.c20241222;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public int maxDistinctElements(int[] nums, int k) {
        int res = 0, max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for (int num : nums) {
            if (max >= num + k) continue;
            res += 1;
            max = Math.max(num - k, max + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1000000000,0};
        int d = 1000000000;
//        System.out.println(new P2().maxPossibleScore(start, d));
    }
}
