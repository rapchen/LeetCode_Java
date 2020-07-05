package algorithm.sort;

/**
 * 排序算法
 * @author Chen Runwen
 * @time 2020/2/4 12:02
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{32,15,12,15,88,1,46,65,10,75,23};
//        Selection.sort(a);
        Insertion.sort(a);
        for (Integer n : a) {
            System.out.print(n);
            System.out.print(',');
        }

    }
}
