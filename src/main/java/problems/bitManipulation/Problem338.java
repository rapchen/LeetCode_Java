package problems.bitManipulation;

import java.util.Arrays;

/**
 * 338. 比特位计数
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 5%
 * @time 2020/7/12 21:59
 */
public class Problem338 {
    /** 去掉最高位的1，73% 5% */
    public int[] countBits1(int num) {
        int[] res = new int[num + 1];
        int power2 = 1;  // 存放下一个2的幂
        for (int i = 1; i <= num; i++) {
            if (i == power2) {
                res[i] = 1;
                power2 <<= 1;
            } else res[i] = res[i - (power2 >> 1)] + 1;
        }
        return res;
    }

    /** 去掉最低位的1，99% 5% */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) res[i] = res[i & (i - 1)] + 1;
        return res;
    }

    public static void main(String[] args) {
        int num = 12;
        System.out.println(Arrays.toString(new Problem338().countBits(num)));
    }
}
