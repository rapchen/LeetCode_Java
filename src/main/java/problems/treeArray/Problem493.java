package problems.treeArray;

/**
 * 493. 翻转对
 * @author Chen Runwen
 * @difficulty H
 * @status TODO
 * @time 2020/7/19 18:08
 */
public class Problem493 {

    public int reversePairs(int[] nums) {

        return 0;
    }

    private static class TreeArray {
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
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,5,1};
        System.out.println(new Problem493().reversePairs(nums));
    }
}
