package problems;

import structs.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * @author Chen Runwen
 * @version 1.0 2019/2/16
 */
public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
