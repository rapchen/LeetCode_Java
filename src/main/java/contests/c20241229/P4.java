package contests.c20241229;

import java.util.Objects;

/**
 * 6244. 完美分割的方案数
 * @author Chen Runwen
 * @difficulty H
 * @status AC
 * @time 2022/11/20 11:23
 */
public class P4 {

    public static final int MOD = 1000000007;

    /**
     * C(n-1, k) * m * (m-1)^(n-k-1)
     */
    public int countGoodArrays(int n, int m, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = div(mul(res, n-i), i);
        }
        res = mul(res, m);
        for (int i = 0; i < n - k - 1; i++) {
            res = mul(res, m-1);
        }
        return (int) res;
    }

    private static long div(long mul, int i) {
        return div(mul, i, MOD);
    }

    private static long div(long a, int b, int mod) {
        if (a % b == 0) {
            return a / b;
        } else if (b < 10) {
            while (a % b != 0) {
                a += mod;
            }
            return a / b;
        } else {
            long k = div(b-(a % b), mod % b, b);
            return (a + k * mod) / b;
        }
    }

    private static long mul(long res, int i) {
        return (res * i) % MOD;
    }


    public static void main(String[] args) {
        long res = div(35687, 65842);
        System.out.println(res);
        System.out.println((res * 65842) % MOD);
        int kx = 0;
        int ky = 2;
        int[][] positions = new int[][]{{1,1},{2,2},{3,3}};
//        System.out.println(new P4().maxMoves(kx, ky, positions));
    }
}
