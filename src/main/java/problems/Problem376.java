package problems;

/**
 * 376. 摆动序列
 * @difficulty M
 * @status AC 100.00%
 * @author Chen Runwen
 * @time 2020/4/25 11:33
 */
public class Problem376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 1, diff;
        byte trend = 0; // 之前的最后一个趋势。上升则为1，下降则为-1。如果之前所有数都一样则为0。
        for (int i = 1; i < nums.length; i++) {
            diff = nums[i] - nums[i-1];
            if (diff > 0) {
                if (trend <= 0) {
                    res ++;
                    trend = 1;
                }
            } else if (diff < 0) {
                if (trend >= 0) {
                    res ++;
                    trend = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        System.out.println(new Problem376().wiggleMaxLength(nums));
    }
}
