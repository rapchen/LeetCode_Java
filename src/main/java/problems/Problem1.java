package problems;

import java.util.*;

/**
 * 1. 两数之和
 * @difficulty E
 * @tags List Hashset
 * @author Chen Runwen
 * @time 2018/3/4
 */
public class Problem1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if (map.containsKey(target - num)) {
                result[0] = map.get(target - num);
                result[1] = i;
                return result;
            }
            map.put(num, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        Problem1 solution = new Problem1();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
