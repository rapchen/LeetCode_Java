package problems.math;

/**
 * 29. 两数相除
 * @author Chen Runwen
 * @difficulty M
 * @status TODO
 * @time 2020/8/15 19:08
 */
public class Problem29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1) return dividend;
        else if (divisor == -1) return dividend == 0x80000000 ? 0x7FFFFFFF : -dividend;
        if (dividend > 0) return -divide(-dividend, divisor);
        if (divisor > 0) return -divide(dividend, -divisor);
        if (dividend > divisor) return 0;

        int i = 1, p = divisor;
        while (p >= dividend && (p & 0x40000000) > 0) {
            p <<= 1;
            i <<= 1;
        }
        return (i >> 1) + divide(dividend - (p >> 1), divisor);
    }

    public static void main(String[] args) {
        int dividend = 2147483647, divisor = 1;
        System.out.println(new Problem29().divide(dividend, divisor));
    }
}
