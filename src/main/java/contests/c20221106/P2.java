package contests.c20221106;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/6 10:52
 */
public class P2 {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> num_cnt = new HashMap<>();
        HashSet<Integer> dup_num = new HashSet<>();
        long cumsum = 0, maxcum = 0;
        for (int i = 0; i < nums.length; i++) {
            cumsum += nums[i];
            num_cnt.put(nums[i], num_cnt.getOrDefault(nums[i], 0) + 1);
            if (num_cnt.get(nums[i]) > 1)
                dup_num.add(nums[i]);
            if (i >= k-1) {
                if (dup_num.isEmpty() && cumsum > maxcum)
                    maxcum = cumsum;
                int num = nums[i - k + 1];
                cumsum -= num;
                num_cnt.put(num, num_cnt.get(num) - 1);
                if (num_cnt.get(num) <= 1)
                    dup_num.remove(num);
            }
        }
        return maxcum;
    }

    public static void main(String[] args) {

    }
}
