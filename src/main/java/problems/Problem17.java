package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * @author Chen Runwen
 * @difficulty M
 * @status AC 90% 5%
 * @time 2020/7/1 23:02
 */
public class Problem17 {
    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        if (len == 0) return new ArrayList<>();

        char[] begins = new char[]{'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        char[] ends = new char[]{'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};
        int[] count = new int[]{3, 3, 3, 3, 3, 4, 3, 4};
        char[] nums = digits.toCharArray();
        List<String> res = new ArrayList<>();

        int total = 1, k;
        char[] cs = new char[len];
        for (int i = 0; i < nums.length; i++) {
            total *= count[nums[i] - 50];
            cs[i] = begins[nums[i] - 50];
        }

        res.add(String.valueOf(cs));
        for (int i = 1; i < total; i++) {
            k = len - 1;
            while (cs[k] == ends[nums[k] - 50]) {
                cs[k] = begins[nums[k] - 50];
                k --;
            }
            cs[k] ++;
            res.add(String.valueOf(cs));
        }

        return res;
    }

    public static void main(String[] args) {
//        String digits = "328476";
        String digits = "7";
        System.out.println(new Problem17().letterCombinations(digits));
    }
}
