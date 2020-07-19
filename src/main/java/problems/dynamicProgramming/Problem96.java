package problems.dynamicProgramming;

/**
 * 96. 不同的二叉搜索树
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 7%
 * @time 2020/7/15 23:44 - 23:50
 */
public class Problem96 {
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        for (int i = 1; i < n + 1; i++)
            for (int j = 0; j < i; j++) nums[i] += nums[j] * nums[i - 1 - j];

        return nums[n];
    }

    public static void main(String[] args) {
        int n = 20;
        System.out.println(new Problem96().numTrees(n));
    }
}
