package problems;

import structs.TreeNode;

import java.util.Stack;

/**
 * 101. Symmetric Tree
 * @author Chen Runwen
 * @time 2019/2/14
 */
public class Problem101 {
    /**
     * 用递归做的
     * @param root
     * @return
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isConversed(root.left, root.right);
    }

    private boolean isConversed(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        }
        if (q == null || p.val != q.val) {
            return false;
        }
        return isConversed(p.left, q.right) && isConversed(p.right, q.left);
    }

    /**
     * 用栈写一下
     * 中根遍历回文的树不一定对称（{1,2,3,3,null,2,null}）
     * 最后采用先根遍历，比较每一节点的左右节点
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();

        leftStack.push(root.left);
        rightStack.push(root.right);

        while (!leftStack.empty()) {
            TreeNode p = leftStack.pop();
            if (rightStack.empty()) {
                return false;
            }
            TreeNode q = rightStack.pop();
            if (p == null && q == null) {
                continue;
            }
            if (p == null || q == null || p.val != q.val) {
                return false;
            }
            leftStack.push(p.right);
            leftStack.push(p.left);
            rightStack.push(q.left);
            rightStack.push(q.right);
        }
        return rightStack.empty();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Integer[]{1,2,3,3,null,2,null});
        System.out.println(new Problem101().isSymmetric(root));
    }
}
