package problems;

/**
 * 137. 只出现一次的数字 II
 * @author Chen Runwen
 * @difficulty M
 * @status AC 76% 14%
 * @time 2020/7/8 22:55 - 23:05
 */
public class Problem137 {
    /** 用high里的一个bit作为高位，nums[0]对应bit作为低位，代表该位上1出现的次数(mod 3)，即 00->01->10->00 76% 14% */
    public int singleNumber1(int[] nums) {
        int high = 0;
        for (int i = 1; i < nums.length; i++) {
            nums[0] = ~high & (nums[0] ^ nums[i]);
            high = ~nums[0] & (high ^ nums[i]);
        }
        return nums[0];
    }

    /** 作弊，用1个额外空间 76% 14% */
    public int singleNumber(int[] nums) {
        int high = 0, low = 0;
        for (int num : nums) {
            low = ~high & (low ^ num);
            high = ~low & (high ^ num);
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,1,0,1,99};
        System.out.println(new Problem137().singleNumber(nums));
    }
}
