package problems.treeArray;

/**
 * 307. 区域和检索 - 数组可修改
 * @author Chen Runwen
 * @difficulty M
 * @status AC 99% 100%
 * @time 2020/7/18 18:20
 */
public class Problem307 {
    int[] values;
    int size;

    public Problem307(int[] nums) {
        size = nums.length;
        values = new int[size];
        System.arraycopy(nums, 0, values, 0, size);
        for (int i = 2; i <= size; i <<= 1)
            for (int j = i - 1; j < size; j += i)
                values[j] += values[j - (i >> 1)];
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

    public void update(int i, int val) {
        int diff = val - get(i);
        values[i] += diff;
        for (int j = 1; j <= size; j <<= 1) {
            if ((i & j) == 0) {
                i = i | j;
                if (i >= size) break;
                values[i] += diff;
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

    public int sumRange(int i, int j) {
        return sumHead(j) - sumHead(i - 1);
    }

}
