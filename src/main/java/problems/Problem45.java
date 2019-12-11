package problems;

/**
 * 45. 跳跃游戏 II
 * @difficulty H
 * @author Chen Runwen
 * @time 2019/12/11 23:58
 */
public class Problem45 {
    public int jump(int[] nums) {
        int len = nums.length;
        // max记录了目前为止从位置0能达到的最大位置
        int max = 0;
        int[] steps = new int[len];
        for (int i = 0; i < len; i++) {
            int newMax = Math.min(i + nums[i], len - 1);
            if (newMax > max) {
                for (int j = max + 1; j <= newMax; j++) {
                    steps[j] = steps[i] + 1;
                }
                max = newMax;
            }
        }
        return steps[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(new Problem45().jump(nums));
    }
}
