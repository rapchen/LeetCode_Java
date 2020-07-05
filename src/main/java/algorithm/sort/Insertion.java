package algorithm.sort;

/**
 * 插入排序
 * @author Chen Runwen
 * @time 2020/4/20 23:40
 */
public class Insertion {

    public static void sort(Comparable[] a) {
        Comparable tmp;
        int i, j;
        for (i = 1; i < a.length; i++) {
            tmp = a[i];
            for (j = i - 1; j >= 0 && tmp.compareTo(a[j]) < 0; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

}
