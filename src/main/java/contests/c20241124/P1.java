package contests.c20241124;

import java.util.List;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int res = -1;
        for (int i = 0; i <= n - l; i++) {
            int tmp = 0;
            for (int j = 0; j < r; j++) {
                if (i + j >= n) {
                    break;
                }
                tmp += nums.get(i+j);
                if (j >= l - 1 && tmp > 0 && (tmp < res || res < 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new P1().minimumSumSubarray(List.of(7,3), 2,2);
    }
}
