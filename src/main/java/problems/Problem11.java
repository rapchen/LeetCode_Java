package problems;

/**
 * 11. 盛最多水的容器
 * @difficulty M
 * @status AC
 * @author Chen Runwen
 * @time 2020/4/18 9:51
 */
public class Problem11 {

    /** 初始做法，最差O(N2) */
    public int maxArea1(int[] height) {
        int len = height.length;
        int[] left = new int[len];  // 存放可能的左边界下标。只有当新的柱子比左边所有柱子高，才可能成为左边界
        left[0] = 0;  // 第一根柱子一定可以作为左边界
        int top = 1;  // left的长度

        int max = 0;
        for (int i = 1; i < len; i++) {
            // 先计算这根柱子跟之前所有左边界柱子围成的最大值
            for (int j = 0; j < top; j++) {
                max = Math.max(max, (i - left[j]) * Math.min(height[i], height[left[j]]));
            }
            // 判断这根柱子能否成为新的左边界
            if (height[i] > height[left[top - 1]]) {
                left[top ++] = i;
            }
        }
        return max;
    }

    /** 双指针，O(N) */
    public int maxArea2(int[] height) {
        int len = height.length;
        int left = 0, right = len - 1;
        int max = 0;
        while (right > left) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;
    }

    /** 在双指针基础上节省了计算次数 */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxS = 0, minH;
        while (right > left) {
            if (height[left] < height[right]) {
                minH = height[left];
                maxS = Math.max(maxS, (right - left) * minH);
                while (height[left] <= minH && left < right)
                    left ++;
            } else {
                minH = height[right];
                maxS = Math.max(maxS, (right - left) * minH);
                while (height[right] <= minH && left < right)
                    right --;
            }
        }
        return maxS;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Problem11().maxArea(height));
    }
}
