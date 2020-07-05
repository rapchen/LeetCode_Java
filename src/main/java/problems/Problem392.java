package problems;

/**
 * 392. 判断子序列
 * @difficulty E
 * @status AC 94.96%,100.00%
 * @author Chen Runwen
 * @time 2020/4/25 11:46
 */
public class Problem392 {
    /** 初始做法，手动遍历t的所有字符 */
    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0) return true;
        char[] cs = s.toCharArray();
        byte j = 0; // 当前s中的位置
        for (int i = 0; i < t.length(); i++) {
            if (cs[j] == t.charAt(i)) {
                if (++j == cs.length) return true;
            }
        }
        return false;
    }

    /** 取巧做法，利用String类型自带的indexOf来查找，可以避免toCharArray带来的开销 */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        char[] cs = s.toCharArray();
        int last = -1; // 上一个字符在t中的位置
        for (char c : cs) {
            last = t.indexOf(c, last + 1);
            if (last == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(new Problem392().isSubsequence(s, t));
    }
}
