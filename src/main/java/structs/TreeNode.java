package structs;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] vals) {
        if (vals.length == 0) {
            return;
        }
        this.val = vals[0];
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(this);
        for (int i = 1; i < vals.length; i++) {
            TreeNode node = null;
            Integer val = vals[i];
            if (val != null) {
                node = new TreeNode(val);
            }
            nodes.add(node);
            if (i % 2 == 0) {
                nodes.get(i/2 - 1).right = node;
            } else {
                nodes.get((i-1) / 2).left = node;
            }
        }
    }
}
