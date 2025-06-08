package contests.c20240721;

import java.util.Arrays;

/**
 * Q3. 找出最大的 N 位 K 回文数
 * @author Chen Runwen
 * @difficulty M 2
 * @status AC
 * @time 2022/11/20 10:46
 */


public class P3 {
    public String largestPalindrome(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, '9');
        switch (k) {
            case 1, 3, 9 -> {;}
            case 2 -> {
                ans[0] = '8'; ans[n-1] = '8';
            }
            case 4 -> {
                if (n <= 3) {
                    Arrays.fill(ans, '8');
                } else {
                    ans[0] = '8'; ans[n-1] = '8';
                    ans[1] = '8'; ans[n-2] = '8';
                }
            }
            case 8 -> {
                if (n <= 5) {
                    Arrays.fill(ans, '8');
                } else {
                    ans[0] = '8'; ans[n-1] = '8';
                    ans[1] = '8'; ans[n-2] = '8';
                    ans[2] = '8'; ans[n-3] = '8';
                }
            }
            case 5 -> {
                ans[0] = '5'; ans[n-1] = '5';
            }
            case 6 -> {
                if (n <= 2) {
                    ans[0] = '6'; ans[n-1] = '6';
                } else {
                    ans[0] = '8'; ans[n-1] = '8';
                    if (n % 2 == 1) {
                        ans[n/2] = '8';
                    } else {
                        ans[n/2] = '7'; ans[n/2-1] = '7';
                    }
                }
            }
            case 7 -> {
                if (n <= 2) {
                    ans[0] = '7'; ans[n-1] = '7';
                } else {
                    int[] mod = new int[]{1,3,2,6,4,5};  // mod 6 mod7
                    int raw = mod[(n) % 6] - 1;
                    for (int i = 9; i >= 0; i--) {
                        if (raw % 7 == 0) {
                            if (n % 2 == 1) {
                                ans[n/2] = (char) (i + 48);
                            } else {
                                ans[n/2] = (char) (i + 48); ans[n/2-1] = (char) (i + 48);
                            }
                            break;
                        }
                        raw += 7 - mod[(n/2) % 6];
                        if (n % 2 == 0) {
                            raw += 7 - mod[(n/2-1) % 6];
                        }
                    }
                }
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        long k = 0;
        for (int i = 1; i < 19; i++) {
            k = k*10+9;
            System.out.println("" + i + " " + k + " " + k%7);
        }

        k = 1;
        for (int i = 1; i < 19; i++) {
            k = k*10;
            System.out.println("" + i + " " + k + " " + k%7);
        }

        int[][]roads = {{0,1},{0,2},{1,3},{1,4}};
        int seats =5;
        System.out.println(new P3().largestPalindrome(3, 7));
    }
}
