package contests.c20250511;

import java.util.*;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] sumRow = new int[m];
        int[] sumCol = new int[n];
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumRow[i] += grid[i][j];
                sumCol[j] += grid[i][j];
            }
            total += sumRow[i];
        }
        if (total % 2 != 0) return false;
        int agg = 0;
        for (int i = 0; i < m-1; i++) {
            agg += sumRow[i];
            if (agg * 2 == total) return true;
        }
        agg = 0;
        for (int j = 0; j < n-1; j++) {
            agg += sumCol[j];
            if (agg * 2 == total) return true;
        }
        return false;
    }
}
