package contests.c20221112;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/12 22:53
 */
public class P3 {
    class TreeNode {
        int id;
        int amount;
        TreeNode father;
        List<TreeNode> sons;
        int score = 0;

        public TreeNode(int id, int amount) {
            this.id = id;
            this.amount = amount;
            this.sons = new ArrayList<>();
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // 构建
        List<TreeNode> tree = new ArrayList<>();
        for (int i = 0; i < amount.length; i++) {
            tree.add(new TreeNode(i, amount[i]));
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).sons.add(tree.get(edge[1]));
            tree.get(edge[1]).sons.add(tree.get(edge[0]));
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(tree.get(0));
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            for (TreeNode son : node.sons) {
                if (son == node.father) continue;
                son.father = node;
                deque.add(son);
            }
        }

        // 重置bob的得分
        List<TreeNode> bobs = new ArrayList<>();
        TreeNode p = tree.get(bob);
        while (p != null) {
            bobs.add(p);
            p = p.father;
        }
        for (int i = 0; i < bobs.size() / 2; i++) {
            bobs.get(i).amount = 0;
        }
        if (bobs.size() % 2 == 1) {
            bobs.get(bobs.size() / 2).amount /= 2;
        }

        // 找
        int ans = Integer.MIN_VALUE;
        deque = new ArrayDeque<>();
        deque.add(tree.get(0));
        tree.get(0).score = tree.get(0).amount;
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();

            for (TreeNode son : node.sons) {
                if (son == node.father) continue;

                son.score = son.amount + node.score;
                if (son.sons.size() == 1 && son.score > ans) ans = son.score;

                deque.add(son);
            }
        }
        return ans;

    }
}
