package problems;

import java.util.*;

/**
 * @author Chen Runwen
 * @version 1.0 2018/3/4
 */
public class Solution001 {
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
        Solution001 solution = new Solution001();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
