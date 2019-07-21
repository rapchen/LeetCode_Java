package utils;

import structs.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树工具类
 * @author Chen Runwen
 * @version 1.0 2019/2/15
 */
public class TreeUtil {
    public static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        while (!stack.empty()) {
            p = stack.pop();
            result.add(p.val);
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
        return result;
    }

    /**
     * 后根遍历 todo 先不写了
     * @param root 根节点
     * @return
     */
    public static List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(new Integer[]{1, 2, 3, 4, 5, null, 7});
        System.out.println(TreeUtil.preOrderTraversal(root));
        System.out.println(TreeUtil.inOrderTraversal(root));
    }
}
