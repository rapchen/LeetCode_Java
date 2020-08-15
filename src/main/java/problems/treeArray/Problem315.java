package problems.treeArray;

import java.util.*;

/**
 * 315. 计算右侧小于当前元素的个数
 * @author Chen Runwen
 * @difficulty H
 * @status AC 97% 16%
 * @time 2020/7/11 15:57
 */
public class Problem315 {

    /** 二叉搜索树，从右往左插入树，插入的时候判断一下比当前元素小的数的个数 97% 16% */
    public List<Integer> countSmaller1(int[] nums) {
        int len = nums.length;
        Integer[] res = new Integer[len];
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = len - 1; i >= 0; i--) {
            res[i] = tree.insert(nums[i]);
        }
        return Arrays.asList(res);
    }

    private static class BinarySearchTree {

        private TreeNode root = null;

        public Integer first() {
            if (root == null) return null;
            TreeNode p = root;
            while (p.left != null) p = p.left;
            return p.val;
        }

        public Integer last() {
            if (root == null) return null;
            TreeNode p = root;
            while (p.right != null) p = p.right;
            return p.val;
        }

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

        public int insert(int k) {
            if (root == null) {
                root = new TreeNode(k);
                return 0;
            }
            return insert(k, root);
        }

        private int insert(int k, TreeNode node) {
            if (k == node.val) {
                node.count ++;
                node.size ++;
                return TreeNode.getSize(node.left);
            }
            int res;
            if (k < node.val) {
                res = 0;
                if (node.left == null) node.left = new TreeNode(k);
                else res = insert(k, node.left);
            }
            else {
                res = TreeNode.getSize(node.left) + node.count;
                if (node.right == null) node.right = new TreeNode(k);
                else res += insert(k, node.right);
            }
            node.size ++;
            return res;
        }

        public boolean contains(int k) {
            TreeNode p = root;
            while (p != null) {
                if (k == p.val) return true;
                if (k > p.val) p = p.right;
                else p = p.left;
            }
            return false;
        }

    }

    private static class TreeNode {
        public int val;
        public int count = 1;  // 当前数值出现的次数
        public int size = 1;  // 以当前节点为根的树中所有数出现的次数
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        private static int getSize(TreeNode node) {
            return node == null ? 0 : node.size;
        }
    }

    /** 用树状数组+二分查找 */
    public List<Integer> countSmaller(int[] nums) {
        // 获取数组中每个数排序后的位置索引，并建立对应关系
        TreeMap<Integer, Integer> numToIndex = new TreeMap<>();
        for (int num : nums) numToIndex.put(num, 0);
        int[] indexToNum = new int[numToIndex.size()];
        int i = 0, index;
        for (Integer key : numToIndex.keySet()) {
            indexToNum[i] = key;
            numToIndex.put(key, i);
            i++;
        }

        // 建立一个树状数组，每个位置上的值分别表示该索引对应的数已经出现的次数。从右往左对所有数依次进行统计，同时得到小于该数的数字个数。
        TreeArray ta = new TreeArray(indexToNum.length);
        Integer[] res = new Integer[nums.length];
        for (i = nums.length - 1; i >= 0; i--) {
            index = numToIndex.get(nums[i]);
            res[i] = ta.sumHead(index - 1);
            ta.addOne(index);
        }
        return Arrays.asList(res);
    }

    private static class TreeArray {
        private final int[] values;
        private final int size;

        public TreeArray(int size) {
            this.size = size;
            values = new int[size];
        }

        public int get(int index) {
            int res = values[index];
            // 处理一下求和
            for (int i = 1; i <= index; i <<= 1) {
                if ((index & i) == 0) break;
                res -= values[index ^ i];
            }
            return res;
        }

        public void addOne(int index) {
            values[index] ++;
            for (int i = 1; i <= size; i <<= 1) {
                if ((index & i) == 0) {
                    index = index | i;
                    if (index >= size) break;
                    values[index] ++;
                }
            }
        }

        /** 求0~last中所有数的和 */
        public int sumHead(int last) {
            int sum = 0;
            last++;
            while (last > 0) {
                sum += values[last - 1];
                last = last & (last - 1);
            }
            return sum;
        }
    }


    /** 用归并，三个平行数组，一个存结果，一个存原顺序 */

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,23,23,12,2};
        System.out.println(new Problem315().countSmaller(nums));
    }
}
