package contests.c20241229;

import java.util.Arrays;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int n = word.length();
        int m = n - numFriends + 1; // 长度
        String res = "";
        for (int i = 0; i < n; i++) {
            String tmp = word.substring(i, Math.min(i + m, n));
            if (tmp.compareTo(res) > 0) res = tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1000000000,0};
        int d = 1000000000;
//        System.out.println(new P2().maxPossibleScore(start, d));
    }
}
