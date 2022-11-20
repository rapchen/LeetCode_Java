package contests.c20221106;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/6 10:42
 */
public class P1 {
    public int[] applyOperations(int[] nums) {
        int[] ans = nums.clone();
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i+1 < nums.length && nums[i] == nums[i+1] && nums[i] != 0) {
                ans[p] = nums[i] * 2;
                i++;
                p++;
            } else if (nums[i] != 0) {
                ans[p] = nums[i];
                p++;
            }
        }
        for (; p < ans.length; p++) {
            ans[p] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
