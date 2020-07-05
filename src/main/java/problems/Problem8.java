package problems;

/**
 * 8. 字符串转换整数 (atoi)
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 5%
 * @time 2020/6/27 12:23
 */
public class Problem8 {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;

        char[] s = str.toCharArray();
        int i = 0, res = 0;
        boolean pos = true;

        while (s[i] == ' ') {
            i++;
            if (i == s.length) return 0;
        }
        if (s[i] == '-') {
            pos = false;
            i++;
        } else if (s[i] == '+') i++;
        else if (s[i] < '0' || s[i] > '9') return 0;

        for (; i < s.length; i++) {
            if (s[i] < '0' || s[i] > '9') break;
            if (res > Integer.MAX_VALUE / 10 |
                    (res == Integer.MAX_VALUE / 10 && s[i] >= (pos ? '7' : '8')))
                return pos ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            res = res * 10 + s[i] - 48;
        }
        return pos ? res : -res;
    }

    public static void main(String[] args) {
        String str = "   -419234513453 with words";
        System.out.println(new Problem8().myAtoi(str));
//        System.out.printf("%d %d %d", Integer.MIN_VALUE, Integer.MIN_VALUE / 10, Integer.MIN_VALUE % 10);
    }
}
