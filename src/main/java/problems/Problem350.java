package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 * @author Chen Runwen
 * @difficulty E
 * @status AC
 * @time 2020/7/13 23:56
 */
public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num: nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

}
