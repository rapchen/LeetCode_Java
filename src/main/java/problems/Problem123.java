package problems;

/**
 * 123. Best Time to Buy and Sell Stock III
 * @author Chen Runwen
 * @time 2019/11/1 21:45
 */
public class Problem123 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 先算前K天中的最大收益（用P121的方法），存起来
        int[] maxUntilDayK = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
            maxUntilDayK[i] = maxProfit;
        }

        // 类似地递推算后K天的最大收益，跟前N-K天加一下即可
        int max = Integer.MIN_VALUE;
        maxProfit = 0;
        int maxSum = maxUntilDayK[maxUntilDayK.length - 1];
        for (int i = prices.length - 1; i > 0; i--) {
            if (prices[i] > max) {
                max = prices[i];
            } else if (max - prices[i] > maxProfit) {
                maxProfit = max - prices[i];
            }
            if (maxProfit + maxUntilDayK[i - 1] > maxSum) {
                maxSum = maxProfit + maxUntilDayK[i - 1];
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(new Problem123().maxProfit(prices));
    }

}
