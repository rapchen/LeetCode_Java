package contests.c20221120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 6242. 二叉搜索树最近节点查询
 * @author Chen Runwen
 * @difficulty M 1
 * @status AC
 * @time 2022/11/20 10:36
 */


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class P2 {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer query : queries) {
            int min_ = -1, max_ = 1000001;
            TreeNode node = root;
//            check(root, query);
            while (node != null) {
                if (node.val == query) {
                    min_ = query;
                    max_ = query;
                    break;
                } else if (node.val < query) {
                    min_ = node.val;
                    node = node.right;
                } else {
                    max_ = node.val;
                    node = node.left;
                }
            }

            if (max_ == 1000001) max_ = -1;
            ans.add(Arrays.asList(min_, max_));
        }
        return ans;
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
