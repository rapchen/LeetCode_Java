package problems.bitManipulation;

/**
 * 461. 汉明距离
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 6%
 * @time 2020/7/12 23:18 - 23:47
 */
public class Problem461 {
    public int hammingDistance(int x, int y) {
        x ^= y;
        x = ((x & 0xAAAAAAAA) >> 1) + (x & 0x55555555);
        x = ((x & 0xCCCCCCCC) >> 2) + (x & 0x33333333);
        x = ((x & 0xF0F0F0F0) >> 4) + (x & 0x0F0F0F0F);
        return x * 0x01010101 >> 24;
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(new Problem461().hammingDistance(x, y));
    }
}
