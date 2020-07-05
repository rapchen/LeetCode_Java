package algorithm.sort;

/**
 * 选择排序
 * @author Chen Runwen
 * @time 2020/4/20 23:35
 */
public class Selection extends Sort{

    public static void sort(Comparable[] a) {
        int min; // 存放当前最小数的下标
        Comparable tmp;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            tmp = a[i];
            a[i] = a[min];
            a[min] = tmp;
        }
    }

}
