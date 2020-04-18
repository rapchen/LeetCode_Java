package problems;

/**
 * 239. 滑动窗口最大值
 * @difficulty H
 * @author Chen Runwen
 * @time 2020/4/6 16:58
 */
public class Problem239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }

        int len = nums.length;
        int[] max = new int[len - k + 1]; // 存结果

        int len2 = k + 2;
        int[] idx = new int[len2]; // 维护一个可能最大值的下标的循环数组，这些可能最大值应该是递减的
        int head = 0, tail = 0; // 循环数组的头尾
        for (int i = 0; i < k - 1; i++) {
            // 只要末尾的数小于当前数，就把末尾弹出
            while (tail != head && nums[i] > nums[idx[(tail - 1 + len2) % len2]]) {
                tail = (tail - 1 + len2) % len2; // rpop
            }
            // 把当前数压入
            idx[tail] = i;
            tail = (tail + 1) % len2; // rpush
        }

        for (int i = k - 1; i < len; i++) {
            // 只要末尾的数小于当前数，就把末尾弹出
            while (tail != head && nums[i] > nums[idx[(tail - 1 + len2) % len2]]) {
                tail = (tail - 1 + len2) % len2; // rpop
            }
            // 把当前数压入
            idx[tail] = i;
            tail = (tail + 1) % len2; // rpush

            // 取出当前的最大值（即开头的数字）
            max[i - k + 1] = nums[idx[head]]; // lpeek

            // 如果当前开头的idx已经在窗口边缘了，就把它去掉
            if (idx[head] == i - k + 1) {
                head = (head + 1) % len2; // lpop
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] max = new Problem239().maxSlidingWindow(nums, k);
        for (int m : max) {
            System.out.print(m);
            System.out.print(',');
        }

    }
}
