package problems;

/**
 * 42. 接雨水
 * @difficulty H
 * @status AC
 * @author Chen Runwen
 * @time 2020/4/18 10:51
 */
public class Problem42 {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int S = 0, minH;
        while (right > left) {
            if (height[left] < height[right]) {
                minH = height[left];
                while (height[left] <= minH && left < right) {
                    S += minH - height[left];
                    left++;
                }
            } else {
                minH = height[right];
                while (height[right] <= minH && left < right) {
                    S += minH - height[right];
                    right--;
                }
            }
        }
        return S;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Problem42().trap(height));
    }
}
