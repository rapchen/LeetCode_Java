package problems;

/**
 * 260. 只出现一次的数字 III
 * @author Chen Runwen
 * @difficulty M
 * @status AC(Ans) 100% 16%
 * @time 2020/7/8 23:36 - 23:42
 */
public class Problem260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0, x = 0;
        // 先把所有数求异或，得到的其实是x和y的差异
        for (int num : nums) diff ^= num;
        // 取出其中的一个1，这是x和y在一位上的差异，它一定来自x和y中的1个
        int oneBit = diff & -diff;
        // 求所有这一位上是0的数的差异，即可得到x和y中的一个
        for (int num : nums)
            if ((num & oneBit) == 0) x ^= num;
        // 另一个直接把它和diff求异或就能得到
        return new int[]{x, x ^ diff};
    }

}
