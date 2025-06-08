package contests.c20240721;

import java.util.*;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC
 * @time 2022/11/20 10:36
 */

public class P2 {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] ansA = new long[n], ansB = new long [n];  // 喝完第k瓶
        ansA[0] = energyDrinkA[0];
        ansB[0] = energyDrinkB[0];
        ansA[1] = energyDrinkA[0] + energyDrinkA[1];
        ansB[1] = energyDrinkB[0] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            ansA[i] = Math.max(ansA[i-1] + energyDrinkA[i], ansB[i-2] + energyDrinkA[i]);
            ansB[i] = Math.max(ansB[i-1] + energyDrinkB[i], ansA[i-2] + energyDrinkB[i]);
        }
        return Math.max(ansA[n-1], ansB[n-1]);
    }
}
