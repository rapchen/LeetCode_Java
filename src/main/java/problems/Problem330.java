package problems;

/**
 * 330. 按要求补齐数组
 * @difficulty H
 * @status AC 100.00%
 * @author Chen Runwen
 * @time 2020/4/25 11:10
 */
public class Problem330 {
    /** 初始想法，从1开始考虑每个数，遇到无法表示的数时，直接把这个数加进去*/
    public int minPatches(int[] nums, int n) {
        int res = 0;
        int i = 0; // 表示现在nums里将要用到的数的位置
        int maxSum = 0; // 这里存放到目前为止的数（nums[0]~nums[i-1]，以及已经添加进去的数）能连续表示的最大的和，即1 ~ maxSum都已经能被表示
        while (maxSum < n) {
            if (i < nums.length && nums[i] - maxSum <= 1) {
                // num 比 maxSum 至多大1时，直接把这个数放进去，就可以表示1 ~ num+maxSum的所有数
                maxSum += nums[i++];
            } else {
                // 否则就必须要加入一个数来表示maxSum+1，这里直接加maxSum+1试试看
                res ++;
                maxSum = maxSum <= 0x3fffffff ? 2*maxSum + 1 : 0x7fffffff;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,10};
        int n = 20;
        System.out.println(new Problem330().minPatches(nums, n));
    }
}
