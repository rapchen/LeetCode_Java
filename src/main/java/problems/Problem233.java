package problems;

/**
 * 233. 数字 1 的个数
 * @author Chen Runwen
 * @difficulty H
 * @status AC 100% 33%
 * @time 2020/7/7 23:34
 */
public class Problem233 {
    /** 递归 100% 33% */
    public int countDigitOne1(int n) {
        if (n <= 0) return 0;
        if (n <= 9) return 1;
        int digits = (int) Math.log10(n);
        int power = (int) Math.pow(10, digits);
        int high = n / power;
        int low = n % power;
        return (high == 1 ? low + 1 : power) + power / 10 * digits * high + countDigitOne(low);
    }

    /** 迭代 100% 33% */
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        if (n <= 9) return 1;
        int digits = (int) Math.log10(n);
        int power = (int) Math.pow(10, digits);
        int res = 0, high, low;
        for (;digits > 0; digits--, power /= 10) {
            high = n / power;
            if (high == 0) continue;
            n %= power;
            res += (high == 1 ? n + 1 : power) + power / 10 * digits * high;
        }
        return res + (n == 0 ? 0 : 1);
    }

    public static void main(String[] args) {
        int n = 412586;
        System.out.println(new Problem233().countDigitOne(n));
    }
}
