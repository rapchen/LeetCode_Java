package problems.binarySearch;

/**
 * 410. 分割数组的最大值
 * @author Chen Runwen
 * @difficulty H
 * @status AC(Ans) 100% 33%
 * @time 2020/7/25 17:01
 */
public class Problem410 {
    /** 动规，应该是O(N*M*logN),O(N) */
    public int splitArray1(int[] nums, int m) {
        return 0;
    }

    /** 二分查找+贪心，O(N*log(sum(nums))) ~ O(NlogN), O(1) */
    public int splitArray(int[] nums, int m) {
        // lo和hi为二分的上下界，其中lo初始化为数组中的最大值，hi初始化为整个数组的和
        int lo = 0, hi = 0, mid;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
            if (hi < 0) hi = 0x7FFFFFFF;
        }
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            if (checkSum(nums, m, mid)) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }

    public boolean checkSum(int[] nums, int m, int sum) {
        // k为当前的分区号，splitSum为当前分区的区间和，当区间和超过sum时，就应该开启下一个分区
        int k = 0, splitSum = 0;
        for (int num : nums) {
            if (sum - splitSum >= num) splitSum += num;
            else {
                k++;
                if (k >= m) return false;
                splitSum = num;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{7,2,5,10,8};
        int[] nums = new int[]{1047483633,1047483633,1047483633};
        int m = 2;
        System.out.println(new Problem410().splitArray(nums, m));
    }
}
