package problems.bitManipulation;

/**
 * 201. 数字范围按位与
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 7%
 * @time 2020/7/11 11:13
 */
public class Problem201 {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) return m;
        int diff = m ^ n, p;
        while ((p = diff & (diff - 1)) != 0) diff = p;
        diff = -(diff << 1);
        return diff & m;
    }

    public static void main(String[] args) {
        int m = 5, n = 5;
        System.out.println(new Problem201().rangeBitwiseAnd(m, n));
    }
}
