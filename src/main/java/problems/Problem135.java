package problems;

/**
 * 135. 分发糖果
 * @difficulty H
 * @status AC 85.96%
 * @author Chen Runwen
 * @time 2019/12/5 23:32
 */
public class Problem135 {
    /** 初始想法，每个学生分到的糖果是从左往右算和从右往左算的较大值 O(N),O(N)*/
    public int candy1(int[] ratings) {
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

    /** 不纠结每个学生具体的值，只算总量，可以递推得到 O(N),O(1)，但差距基本看不出来 */
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }

        int sum = 1, lastMax = 1, maxPos = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (maxPos == i - 1) {
                    lastMax++;
                } else {
                    lastMax = 2;
                }
                sum += lastMax;
                maxPos = i;
            } else if (ratings[i] < ratings[i - 1]) {
                if (i - maxPos == lastMax) {
                    sum += ++lastMax;
                } else {
                    sum += i - maxPos;
                }
            } else {
                lastMax = 1;
                sum ++;
                maxPos = i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
//        int[] ratings = new int[] {1, 0, 2};
        int[] ratings = new int[] {1,0,2,2,4,2,3,2,2,2,1,1,3};
//        int[] ratings = new int[] {1,0,2,2,4,2,3,2,2,2,1,1,3,43,4,23,2,32,3};

        System.out.println(new Problem135().candy(ratings));
    }
}
