package problems;

/**
 * 55. 跳跃游戏
 * @difficulty M
 * @author Chen Runwen
 * @time 2019/12/9 16:26
 */
public class Problem55 {
    // TODO 70%
    public boolean canJump(int[] nums) {
        int len = nums.length;
        // max记录了目前为止从位置0能达到的最大位置
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        System.out.println(new Problem55().canJump(nums));
    }

}
