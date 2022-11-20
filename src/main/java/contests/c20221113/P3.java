package contests.c20221113;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/13 10:26
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


public class P3 {

    static class UnionFind {
        int[] a;

        UnionFind(int size) {
            a = new int[size];
            Arrays.fill(a, -1);
        }

        void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot != qRoot) {
                if (a[pRoot] < a[qRoot]) {
                    a[pRoot] += a[qRoot];
                    a[qRoot] = pRoot;
                } else {
                    a[qRoot] += a[pRoot];
                    a[pRoot] = qRoot;
                }
            }
        }

        int find(int p) {
            while (a[p] >= 0) p = a[p];
            return p;
        }

    }

    ArrayList<ArrayList<Integer>> floors;

    public int minimumOperations(TreeNode root) {
        floors = new ArrayList<>();
        floorSearch(root, 0);

        int ans = 0;
        for (int i = 1; i < floors.size(); i++) {
            ArrayList<Integer> floor = floors.get(i);
            HashMap<Integer, Integer> before = new HashMap<>();  // 值，idx
            int m = floor.size();
            for (int j = 0; j < m; j++) {
                before.put(floor.get(j), j);
            }
            floor.sort((a, b) -> a-b);
            UnionFind uf = new UnionFind(m);
            for (int j = 0; j < m; j++) {
                uf.union(j, before.get(floor.get(j)));
            }
            ans += m;
            for (int j = 0; j < m; j++) {
                if (uf.a[j] < 0) ans--;
            }
        }
        return ans;
    }

    private void floorSearch(TreeNode node, int floor) {
        if (node == null) return;
        if (floors.size() <= floor) floors.add(new ArrayList<>());
        floors.get(floor).add(node.val);
        floorSearch(node.left, floor + 1);
        floorSearch(node.right, floor + 1);
    }

    public static void main(String[] args) {
        Integer[] vals = new Integer[]{1,2,3,4,5,6};
        TreeNode root = new TreeNode(vals);
        System.out.println(new P3().minimumOperations(root));
    }
}
