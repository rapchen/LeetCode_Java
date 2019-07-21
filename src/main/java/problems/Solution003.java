package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chen Runwen
 * @version 1.0 2018/3/6
 */


public class Solution003 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int beginPos = 0;
        char c;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (!set.contains(c)) {
                set.add(c);
                maxLength = set.size() > maxLength ? set.size() : maxLength;
            } else {
                while (beginPos < i) {
                    if (s.charAt(beginPos) == c) {
                        beginPos++;
                        break;
                    }
                    set.remove(s.charAt(beginPos));
                    beginPos++;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution003 solution = new Solution003();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

}
