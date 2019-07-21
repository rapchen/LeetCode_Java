package problems;

import structs.TreeNode;

/**
 * 100. Same Tree
 * @author Chen Runwen
 * @version 1.0 2019/2/14
 */

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}