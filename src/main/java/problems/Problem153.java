package problems;

/**
 * 153. 寻找旋转排序数组中的最小值
 * @author Chen Runwen
 * @date 2019/12/12 20:23
 */
public class Problem153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        // 如果没有旋转，直接返回
        if (nums[right] > nums[left]) {
            return nums[left];
        }
        while (true) {
            if (right - left <= 1) {
                return nums[right];
            }
            mid = (left + right) / 2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new Problem153().findMin(nums));
    }
}
