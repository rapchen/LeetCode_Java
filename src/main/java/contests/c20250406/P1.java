package contests.c20250406;

/**
 * Q1. 移除最小数对使数组有序 I
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minimumPairRemoval(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean ok = true;
            int minSumIdx = 1;
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j] < nums[j-1]) ok = false;
                if (nums[j] + nums[j-1] < nums[minSumIdx] + nums[minSumIdx - 1]) {
                    minSumIdx = j;
                }
            }
            if (ok) return i;
            nums[minSumIdx-1] = nums[minSumIdx] + nums[minSumIdx - 1];
            for (int j = minSumIdx+1; j < nums.length - i; j++) {
                nums[j-1] = nums[j];
            }
        }
        return nums.length;
    }
}
