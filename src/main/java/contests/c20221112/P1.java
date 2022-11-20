package contests.c20221112;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Chen Runwen
 * @difficulty
 * @status TODO
 * @time 2022/11/12 22:45
 */
public class P1 {
    public int distinctAverages(int[] nums) {
        HashSet<Integer> answers = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i*2 < nums.length; i++) {
            int avg = nums[i] + nums[nums.length - i - 1];
            answers.add(avg);
        }
        return answers.size();
    }
}
