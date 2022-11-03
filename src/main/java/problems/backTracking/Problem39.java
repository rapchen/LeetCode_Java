package problems.backTracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 39. 组合总和
 * @author Chen Runwen
 * @difficulty M
 * @status AC 87% 72%
 * @time 2020/9/9 21:43
 */
public class Problem39 {
    /** 回溯 */
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> nums = new ArrayDeque<>();

        dfs1(candidates, target, res, nums, 0);
        return res;
    }

    private void dfs1(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> nums, int idx) {
        if (idx == candidates.length || target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }

        nums.addLast(candidates[idx]);
        dfs1(candidates, target - candidates[idx], res, nums, idx);
        nums.removeLast();

        dfs1(candidates, target, res, nums, idx+1);
    }

    /** 回溯，每次一轮，减少判断次数 */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        dfs(candidates, target, res, nums, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> res, List<Integer> nums, int begin) {
        if (target == 0) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (target < candidates[i]) continue;
            nums.add(candidates[i]);
            dfs(candidates, target - candidates[i], res, nums, i);
            nums.remove(nums.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        System.out.println(new Problem39().combinationSum(candidates, target));
    }
}
