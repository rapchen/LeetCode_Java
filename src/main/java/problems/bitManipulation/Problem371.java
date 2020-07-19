package problems.bitManipulation;

/**
 * 371. 两整数之和
 * @author Chen Runwen
 * @difficulty M
 * @status AC 100% 8%
 * @time 2020/7/12 22:56
 */
public class Problem371 {
    public int getSum(int a, int b) {
        while (b != 0) {
            a = a ^ b;
            b = (~a & b) << 1;
        }
        return a;
//        return a ^ b ^ (a & b) << 1;
    }

    public static void main(String[] args) {
        int a = 22134123, b = -12341234;
        System.out.println(new Problem371().getSum(a, b));
    }
}
