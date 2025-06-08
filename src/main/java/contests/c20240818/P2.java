package contests.c20240818;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC
 * @time 2022/11/20 10:36
 */

public class P2 {
    public boolean doesAliceWin(String s) {
        Set<Character> cs = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        boolean ans = s.chars().anyMatch(c -> cs.contains((char) c));
        return ans;
    }
}
