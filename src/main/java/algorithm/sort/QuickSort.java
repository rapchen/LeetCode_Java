package algorithm.sort;

/**
 * @author Chen Runwen
 * @time 2020/4/20 23:41
 */
public class QuickSort {

    private static void quickSort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int i = lo, j = hi;
        Comparable mid = a[lo], tmp;
        while (true) {
            while (i < j && a[j].compareTo(mid) > 0) j--;
            while (i < j && a[i].compareTo(mid) <= 0) i++;
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

    public static void sort(Comparable[] a) {
        quickSort(a, 0, a.length - 1);
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{32,15,12,15,88,1,46,65,10,75,23};
        sort(a);
        for (Integer n : a) {
            System.out.print(n);
            System.out.print(',');
        }

    }

}
