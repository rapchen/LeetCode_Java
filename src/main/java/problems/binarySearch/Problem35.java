package problems.binarySearch;

/**
 * 35. 搜索插入位置
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 5%
 * @time 2020/7/17 23:01
 */
public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 1;
        int lo = 0, hi = nums.length, mid;
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 0;
        System.out.println(new Problem35().searchInsert(nums, target));
    }
}
