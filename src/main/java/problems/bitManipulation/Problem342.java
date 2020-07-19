package problems.bitManipulation;

/**
 * 342. 4的幂
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 7%
 * @time 2020/7/12 21:52
 */
public class Problem342 {
    public boolean isPowerOfFour(int num) {
        return (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
