package problems;

/**
 * 435. 无重叠区间
 * @difficulty M
 * @status AC 87.75%
 * @author Chen Runwen
 * @time 2020/4/19 10:48
 */
public class Problem435 {

    /** 按区间结尾排序 */
    private static void quickSort(int[][] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int i = lo, j = hi;
        int[] mid = a[lo];
        int[] tmp;
        while (true) {
            while (i < j && a[j][1] > mid[1]) j--;
            while (i < j && a[i][1] <= mid[1]) i++;
            if (i >= j) {
                break;
            }
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        a[lo] = a[j];
        a[j] = mid;
        quickSort(a, lo, j - 1);
        quickSort(a, j + 1, hi);
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }

        // 按区间结尾排序
        quickSort(intervals, 0, intervals.length - 1);
        // 按顺序比较，如果遇到冲突的，就删除结尾靠后的那个区间
        int erased = 0;
        int[] last = intervals[0]; // 存放最后一个没有冲突的区间
        for (int i = 1; i < intervals.length; i++) {
            if (last[1] <= intervals[i][0]) {
                last = intervals[i];
            } else {
                erased ++;
            }
        }
        return erased;
    }

    public static void main(String[] args) {
//        int[][] intervals = new int[][]{{1,2},{2,3},{3,4},{1,3}};
        int[][] intervals = new int[][]{{1,2},{1,2},{1,2}};
        System.out.println(new Problem435().eraseOverlapIntervals(intervals));
    }
}
