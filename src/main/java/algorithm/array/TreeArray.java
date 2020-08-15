package algorithm.array;

/**
 * 树状数组(int)
 * @author Chen Runwen
 * @time 2020/7/18 16:54
 */
public class TreeArray {
    private int[] values;
    private int size = 0;

    public TreeArray() {
        values = new int[16];
    }

    public TreeArray(int maxSize) {
        values = new int[maxSize];
    }

    public void insertLast(int value) {
        // 本次插入将造成溢出时，对values数组进行扩展
        if (size == values.length) {
            int[] newValues = new int[size * 2];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }
        // 新插入的值在插入前的size位置
        values[size] = value;
        // 处理一下求和
        for (int i = 1; i <= size; i <<= 1) {
            if ((size & i) == 0) break;
            values[size] += values[size ^ i];
        }
        size++;
    }

    public int get(int index) {
        int res = values[index];
        // 处理一下求和
        for (int i = 1; i <= index; i <<= 1) {
            if ((index & i) == 0) break;
            res -= values[index ^ i];
        }
        return res;
    }

    public void update(int index, int value) {
        int diff = value - get(index);
        values[index] += diff;
        for (int i = 1; i <= size; i <<= 1) {
            if ((index & i) == 0) {
                index = index | i;
                if (index >= size) break;
                values[index] += diff;
            }
        }
    }

    /** 求0~last中所有数的和 */
    public int sumHead(int last) {
        int sum = 0;
        last++;
        while (last > 0) {
            sum += values[last - 1];
            last = last & (last - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeArray a = new TreeArray(8);
        for (int i = 0; i < 14; i++) a.insertLast(1);
        for (int i = 0; i < 14; i++) System.out.printf("%d, ", a.get(i));
        System.out.println();
        for (int i = 0; i < 14; i++) System.out.printf("%d, ", a.sumHead(i));
        System.out.println();

        for (int i = 0; i < 14; i++) a.update(i, i);
        for (int i = 0; i < 14; i++) System.out.printf("%d, ", a.get(i));
        System.out.println();
        for (int i = 0; i < 14; i++) System.out.printf("%d, ", a.sumHead(i));
        System.out.println();

    }
}
