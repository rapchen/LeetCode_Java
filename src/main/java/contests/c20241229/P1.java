package contests.c20241229;

import java.util.HashSet;
import java.util.Set;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            int last = grid[0][i];
            for (int j = 1; j < m; j++) {
                if (grid[j][i] <= last) {
                    last += 1;
                    res += last - grid[j][i];
                } else {
                    last =  grid[j][i];
                }
            }
        }
        return res;
    }

//    public static void main(String[] args) {
//        new P1().minimumSumSubarray(List.of(7,3), 2,2);
//    }
}
