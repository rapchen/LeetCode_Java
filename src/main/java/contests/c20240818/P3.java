package contests.c20240818;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public int maxOperations(String s) {
        int ans = 0;
        int zeros = 0;
        boolean lastZero = false;
        for (int i = s.length() -1; i >= 0 ; i--) {
            if (s.charAt(i) == '0') {
                if (!lastZero) {
                    zeros++;
                    lastZero = true;
                }
            } else {
                ans += zeros;
                lastZero = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
//        int seats =5;
//        System.out.println(new P3().maxTotalReward(roads, seats));
    }
}
