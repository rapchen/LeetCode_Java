package problems;

/**
 * 136. 只出现一次的数字
 * @author Chen Runwen
 * @difficulty E
 * @status 99% 5%
 * @time 2020/7/8 22:53 - 22:54
 */
public class Problem136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) res = res ^ num;
        return res;
    }

}
