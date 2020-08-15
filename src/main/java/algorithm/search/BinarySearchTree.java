package algorithm.search;

/**
 * 二叉查找树
 * @author Chen Runwen
 * @time 2020/7/11 16:42
 */
public class BinarySearchTree implements SortedSet {

    private TreeNode root = null;

    @Override
    public Integer first() {
        if (root == null) return null;
        TreeNode p = root;
        while (p.left != null) p = p.left;
        return p.val;
    }

    @Override
    public Integer last() {
        if (root == null) return null;
        TreeNode p = root;
        while (p.right != null) p = p.right;
        return p.val;
    }

    @Override
    public Integer index(int key) {
        int res = 0;
        TreeNode p = root;
        while (p != null) {
            if (key == p.val) return res + TreeNode.getSize(p.left);
            if (key < p.val) p = p.left;
            else {
                res += TreeNode.getSize(p.left) + 1;
                p = p.right;
            }
        }
        return null;
    }

    @Override
    public Integer at(int index) {
        if (index < 0 || index >= TreeNode.getSize(root)) return null;
        return at(index, root);
    }

    private Integer at(int index, TreeNode node) {
        int leftSize = TreeNode.getSize(node.left);
        if (index == leftSize) return node.val;
        if (index < leftSize) return at(index, node.left);
        else return at(index - leftSize - 1, node.right);
    }

    @Override
    public void insert(int k) {
        root = insert(k, root);
    }

    private TreeNode insert(int k, TreeNode node) {
        if (node == null) return new TreeNode(k);
        if (k == node.val) return node;
        if (k > node.val) node.right = insert(k, node.right);
        else node.left = insert(k, node.left);
        node.size = TreeNode.getSize(node.left) + TreeNode.getSize(node.right) + 1;
        return node;
    }

    @Override
    public boolean contains(int k) {
        TreeNode p = root;
        while (p != null) {
            if (k == p.val) return true;
            if (k > p.val) p = p.right;
            else p = p.left;
        }
        return false;
    }


    private static class TreeNode {
        public int val;
        public int size = 1;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        private static int getSize(TreeNode node) {
            return node == null ? 0 : node.size;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] keys = new int[]{5,2,7,3,8,1,4,6};
        for (int key : keys) tree.insert(key);
        System.out.println(tree.at(6));
        System.out.println(tree.index(3));
    }
}
