package problems;

/**
 * 238. 除自身以外数组的乘积
 * @difficulty M
 * @status AC
 * @author Chen Runwen
 * @time 2020/4/18 16:27
 */
public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 1) {
            return new int[]{1};
        }

        // 先计算每个数左边数的乘积，直接存到结果数组里
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        // 计算每个数右边数的乘积，乘到结果里得到总乘积
        int rightProduct = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct *= nums[i + 1];
            res[i] *= rightProduct;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new Problem238().productExceptSelf(nums);
        for (int num : res) {
            System.out.println(num);
        }
    }
}
