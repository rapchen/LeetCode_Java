package contests.c20240721;

/**
 * 6241. 数组中不等三元组的数目
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int zero = 0, one = 0;
            for (int j = i; j < n; j++) {
                if (chars[j] == '1') one++; else zero++;
                if (zero > k && one > k) break;
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new P1().countKConstraintSubstrings("10101",1);
    }
}
