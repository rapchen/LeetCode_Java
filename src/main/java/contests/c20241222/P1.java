package contests.c20241222;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int i;
        for (i = n - 1; i >= 0; i--) {
            if (set.contains(nums[i])) {
                return i / 3 + 1;
            }
            set.add(nums[i]);
        }
        return 0;
    }

//    public static void main(String[] args) {
//        new P1().minimumSumSubarray(List.of(7,3), 2,2);
//    }
}
