package contests.c20241222;

/**
 * 6243. 到达首都的最少油耗
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public int minLength(String s, int numOps) {
        char[] cs = s.toCharArray();
        // 值域二分 (lo, hi]
        int lo = 0, hi = cs.length;
        while (hi - lo > 1) {
            int mid = (hi + lo) / 2;
            if (success(mid, numOps, cs)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi;
    }

    private boolean success(int k, int numOps, char[] cs) {
        if (k == 1) {
            char last = '0';
            int minOps = 0;
            for (char c : cs) {
                last = last == '0' ? '1' : '0';
                if (last != c) minOps++;
            }
            return minOps <= numOps || (cs.length - minOps) <= numOps;
        }

        char last = '\0';
        int dup = 0;
        int minOps = 0;
        for (char c : cs) {
            if (c != last) {
                last = c;
                dup = 1;
            } else {
                dup ++;
                if (dup > k) {
                    dup -= (k+1);
                    minOps ++;
                }
            }
        }
        return minOps <= numOps;
    }

    public static void main(String[] args) {

    }
}