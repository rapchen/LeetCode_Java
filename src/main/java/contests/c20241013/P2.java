package contests.c20241013;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC21
 * @time 2022/11/20 10:36
 */

public class P2 {
    public static class Pair {
        int cnt;
        boolean perfect;

        public Pair(int cnt, boolean perfect) {
            this.cnt = cnt;
            this.perfect = perfect;
        }
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        List<Integer> per = new ArrayList<>();
        dfs(root, per);
        per.sort((a, b) -> b-a);
        return per.size() >= k ? per.get(k-1): -1;
    }

    public Pair dfs(TreeNode node, List<Integer> per) {
        // 树大小、是否完全
        if (node == null) return new Pair(0, true);
        Pair left = dfs(node.left, per);
        Pair right = dfs(node.right, per);
        Pair res = new Pair(left.cnt + right.cnt + 1, false);
        if (left.perfect && right.perfect && left.cnt == right.cnt) {
            res.perfect = true;
            per.add(res.cnt);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] start = new int[]{1000000000,0};
        int d = 1000000000;
//        System.out.println(new P2().maxPossibleScore(start, d));
    }
}
