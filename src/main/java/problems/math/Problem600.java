package problems.math;

/**
 * @author Chen Runwen
 * @difficulty H
 * @status 100% 46%
 * @time 2020/9/9 23:19-23:42
 */
public class Problem600 {
    /** 类似于递归 */
    public int findIntegers(int num) {
        if (num == 0) return 1;
        // fibo[k]代表了2^k-1以内的数中不含连续1的个数。递推恰好是斐波那契数列
        int[] fibo = new int[31];
        fibo[0] = 1;
        fibo[1] = 2;
        for (int i = 2; i < 31; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
        }

        int result = 0;
        // 从高位开始分析每一个1
        for (int i = 30, p = 0x40000000; i >= 1; i--, p>>=1) {
            if (p > num) continue;
            if (num - p >= (p >> 1)) {
                // 如果高位连续两个1，那么这个数以内跟2^(i+1)-1以内的不含连续1的个数是相等的
                result += fibo[i+1];
                return result;
            } else {
                // 否则可以把它拆成两部分，一部分是2^i-1，另一部分是num-2^i
                result += fibo[i];
                num -= p;
            }
        }
        return result + num + 1;
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println(new Problem600().findIntegers(num));
    }
}
