package contests.c20250608;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Q1. 移除最小数对使数组有序 I
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public boolean canMakeEqual(int[] nums, int k) {
        int ones = 0, negs =  0;
        for (int num : nums) {
            if (num == 1) ones++;
            else negs++;
        }
        if ((ones > k * 2 || ones % 2 == 1) &&
                (negs > k * 2 || negs % 2 == 1)) return false;
        int n = nums.length;
        int[] cp = new int[n];
        System.arraycopy(nums, 0, cp, 0, n);

        int tmp = k;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == -1) {
                tmp--;
                nums[i] = 1;
                nums[i+1] = -nums[i+1];
            }
        }
        if (nums[n-1] == 1 && tmp >= 0) return true;

        tmp = k;
        for (int i = 0; i < n - 1; i++) {
            if (cp[i] == 1) {
                tmp--;
                cp[i] = -1;
                cp[i+1] = -cp[i+1];
            }
        }
        if (cp[n-1] == -1 && tmp >= 0) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,1,-1,1};
        int k = 3;
        new P1().canMakeEqual(nums, k);
    }
}
