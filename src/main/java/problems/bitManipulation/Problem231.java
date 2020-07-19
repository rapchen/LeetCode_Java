package problems.bitManipulation;

/**
 * 231. 2的幂
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 6%
 * @time 2020/7/7 23:29 - 23:33
 */
public class Problem231 {
    /** 朴素算法，O(logN) */
    public boolean isPowerOfTwo1(int n) {
        if (n <= 0) return false;
        while ((n & 1) == 0) {
            n >>= 1;
        }
        return (n >> 1) == 0;
    }

    /** 快速算法，O(1) */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

}
