package contests.c20240707;

import java.util.ArrayList;
import java.util.List;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC
 * @time 2022/11/20 10:36
 */

public class P2 {
    public List<String> validStrings(int n) {
        char[] tmp = new char[n];
        List<String> res = new ArrayList<>();
        dfs(n, 0, tmp, res);
        return res;
    }

    private void dfs(int n, int i, char[] tmp, List<String> res) {
        if (i == n) {
            res.add(new String(tmp));
            return;
        }
        tmp[i] = '1';
        dfs(n, i+1, tmp, res);
        if (i == 0 || tmp[i-1] == '1') {
            tmp[i] = '0';
            dfs(n, i+1, tmp, res);
        }
    }
//
//    private void check(TreeNode node, Integer query) {
//        if (node == null) return;
//        if (node.val == query) {
//            min_ = query;
//            max_ = query;
//            return;
//        }
//        if (node.val < query) {
//            min_ = node.val;
//            check(node.right, query);
//        } else {
//            max_ = node.val;
//            check(node.left, query);
//        }
//    }
}
