package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * @difficulty M
 * @author Chen Runwen
 * @time 2018/3/6
 */
public class Problem3 {
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
        Problem3 solution = new Problem3();
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

}
