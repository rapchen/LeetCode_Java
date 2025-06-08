package contests.c20240707;

import java.util.Arrays;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int n = rewardValues.length;

        // [lo, hi)
        int lo = rewardValues[n-1], hi = rewardValues[n-1] * 2, mid;
        while (hi - lo > 1) {
            mid = (lo + hi) / 2;
            if (canDo(rewardValues, n, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean canDo(int[] rewardValues, int n, int mid) {

        return false;
    }
//
//    public int maxTotalReward(int[] rewardValues) {
//        Arrays.sort(rewardValues);
//        int n = rewardValues.length;
//        int k = rewardValues[n-1];  // 当前最小的数
//        int sum = rewardValues[n-1];
//        for (int i = n-2; i >= 0; i--) {
//            if (rewardValues[i] < k) {
//                k = rewardValues[i];
//                sum += k;
//            }
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        for (int i = -1; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
