package contests.c20221106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6232. 最小移动总距离
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/6 11:35
 */
// 动规
public class P4 {
    class Factory{
        int position;
        int limit;

        public Factory(int position, int limit) {
            this.position = position;
            this.limit = limit;
        }
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        long[] dp = new long[robot.size() + 1];  // 放前i个机器人
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 30000000000000L;
        }
        robot.sort((a, b) -> a-b);
        List<Factory> facs = new ArrayList<>();
        for (int[] ints : factory) {
            facs.add(new Factory(ints[0], ints[1]));
        }
        facs.sort((a, b) -> a.position-b.position);

        for (int i = 0; i < facs.size(); i++) {
            Factory fac = facs.get(i);
            for (int j = robot.size(); j > 0; j--) {
                long cum = 0;
                for (int k = j-1; k >= 0; k--) {
                    if (j - k > fac.limit) break;
                    cum += Math.abs(fac.position - robot.get(k));
                    dp[j] = Math.min(dp[j], dp[k]+cum);
                }
            }
        }
        return dp[robot.size()];
    }

    public static void main(String[] args) {
        List<Integer> robot = Arrays.asList(9,11,99,101);
        int[][] factory = {{10,1},{7,1},{14,1},{100,1},{96,1},{103,1}};
        System.out.println(new P4().minimumTotalDistance(robot, factory));
    }
}
