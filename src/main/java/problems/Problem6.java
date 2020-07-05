package problems;

/**
 * 6. Z 字形变换
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 100%
 * @time 2020/6/27 12:10 - 12:21
 */
public class Problem6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        char[] c = s.toCharArray();
        StringBuilder res = new StringBuilder();
        int interval = (numRows - 1) * 2, len = s.length();
//        int periods = s.length() / ((numRows - 1) * 2);
        for (int j = 0; j < len; j += interval) {
            res.append(c[j]);
        }
        for (int i = 1; i < numRows - 1; i++) {
            for (int j = i; j < len; j += interval) {
                res.append(c[j]);
                if (j + interval - i * 2 < len)
                    res.append(c[j + interval - i * 2]);
            }
        }
        for (int j = numRows - 1; j < len; j += interval) {
            res.append(c[j]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(new Problem6().convert(s, numRows));
    }
}
