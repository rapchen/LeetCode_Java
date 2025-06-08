package contests.c20240908;

import java.util.List;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public long findMaximumScore(List<Integer> nums) {
        long sum = 0;
        int lastI = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) <= nums.get(lastI)) continue;
            sum += ((long) nums.get(lastI)) * (i-lastI);
            lastI = i;
        }
        sum += ((long) nums.get(lastI)) * (nums.size()-1-lastI);
        return sum;
    }

    public static void main(String[] args) {
//        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
//        int seats =5;
//        System.out.println(new P3().maxTotalReward(roads, seats));
    }
}