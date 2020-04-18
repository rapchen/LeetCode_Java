package problems;

/**
 * 152. 乘积最大子数组
 * @difficulty M
 * @status AC
 * @tags DP
 * @author Chen Runwen
 * @time 2020/4/18 16:46
 */
public class Problem152 {
    /** 初始做法，同时保存最大正积和最小负积，O(N)*/
    public int maxProduct1(int[] nums) {
        int res = nums[0];  // 存放到目前为止最大的积
        int maxPos = 0, minNeg = 0, tmp;  // 存放以当前数组元素为结尾的子序列中，最大的正乘积和最小的负乘积
        for (int num : nums) {
            if (num == 0) { // 当前数为0，乘积必然为0
                maxPos = minNeg = 0;
                res = Math.max(res, maxPos);
            } else if (num > 0) { // 当前数为正，最大最小均乘上当前数。如果之前没有负数则最小仍为0
                maxPos = num * Math.max(maxPos, 1);
                minNeg = num * Math.min(minNeg, 0);
                res = Math.max(res, maxPos);
            } else { // 当前数为负，最大最小均乘上当前数然后交换
                tmp = num * Math.min(minNeg, 0);
                minNeg = num * Math.max(maxPos, 1);
                maxPos = tmp;
                if (maxPos > 0)
                    res = Math.max(res, maxPos);
            }
        }
        return res;
    }

    /** 优化掉一个num==0的判断，逻辑更清晰了 */
    public int maxProduct2(int[] nums) {
        int res = nums[0];  // 存放到目前为止最大的积
        int maxPos = 1, minNeg = 1, tmp;  // 存放以当前数组元素为结尾的子序列中，最大的正乘积和最小的负乘积
        for (int num : nums) {
            if (num > 0) { // 当前数为正，最大最小均乘上当前数
                maxPos = Math.max(num * maxPos, num);
                minNeg = Math.min(num * minNeg, num);
            } else { // 当前数为负，最大最小均乘上当前数然后交换
                tmp = Math.max(num * minNeg, num);
                minNeg = Math.min(num * maxPos, num);
                maxPos = tmp;
            }
            res = Math.max(res, maxPos);
        }
        return res;
    }

    /** 取个巧，直接正反向两次遍历出结果，可以避免绝大多数比较 */
    public int maxProduct(int[] nums) {
        int res = nums[0];  // 存放到目前为止最大的积
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            res = Math.max(res, product);
            if (product == 0)
                product = 1;
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            res = Math.max(res, product);
            if (product == 0)
                product = 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,-2,4};
        int[] nums = {-2,0,-1};
        System.out.println(new Problem152().maxProduct(nums));
    }
}
