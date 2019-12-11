package problems;

/**
 * 135. 分发糖果
 * @difficulty H
 * @author Chen Runwen
 * @time 2019/12/5 23:32
 */
public class Problem135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if (len <= 1) {
            return len;
        }

        int[] result = new int[len];
        result[0] = 1;
        for (int i = 1; i < len; i++) {
            result[i] = ratings[i] > ratings[i - 1] ? result[i - 1] + 1 : 1;
        }
        int sum = result[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], ratings[i] > ratings[i + 1] ? result[i + 1] + 1 : 1);
            sum += result[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = new int[] {1, 2, 2};

        System.out.println(new Problem135().candy(ratings));
    }
}
