package problems;

/**
 * 41. 缺失的第一个正数
 * @author Chen Runwen
 * @difficulty H
 * @status AC 87% 8%
 * @time 2020/6/27 12:05
 */
public class Problem41 {
    /** （题解） */
    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        int i, m;
        for (i = 0; i < n; i++)
            if (nums[i] < 1 || nums[i] > n) nums[i] = n + 1;

        for (i = 0; i < n; i++) {
            m = Math.abs(nums[i]);
            if (m >= 1 && m <= n && nums[m - 1] > 0)
                nums[m - 1] = -nums[m - 1];
        }

        for (i = 0; i < n; i++)
            if (nums[i] > 0) break;

        return i + 1;
    }

    /** 修改判断 */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i, m;
        for (i = 0; i < n; i++)
            if (nums[i] < 1) nums[i] = n + 1;

        for (i = 0; i < n; i++) {
            m = Math.abs(nums[i]);
            if (((m - 1) | (n - m)) >= 0 && nums[m - 1] > 0)
                nums[m - 1] = -nums[m - 1];
        }

        for (i = 0; i < n; i++)
            if (nums[i] > 0) break;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(new Problem41().firstMissingPositive(nums));
    }
}
