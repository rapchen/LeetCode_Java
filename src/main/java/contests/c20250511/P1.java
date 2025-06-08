package contests.c20250511;

import java.util.*;

/**
 * Q1. 移除最小数对使数组有序 I
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2022/11/20 10:32
 */
public class P1 {
    public int minDeletion(String s, int k) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : s.toCharArray()) {
            chars.put(c, chars.computeIfAbsent(c, cc -> 0) + 1);
        }
        ArrayList<Integer> counts = new ArrayList<>(chars.values());
        if (counts.size() <= k) return 0;
        int res = 0;
        Collections.sort(counts);
        for (int i = 0; i < counts.size() - k; i++) {
            res += counts.get(i);
        }
        return res;
    }
}
