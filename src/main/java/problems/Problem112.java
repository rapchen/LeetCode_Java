package problems;

import structs.TreeNode;

/**
 * 112. 路径总和
 * @author Chen Runwen
 * @difficulty E
 * @status AC 100% 6%
 * @time 2020/7/7 22:27 - 22:42
 */
public class Problem112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        if (root.left != null && hasPathSum(root.left, sum)) return true;
        return root.right != null && hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {

    }
}
