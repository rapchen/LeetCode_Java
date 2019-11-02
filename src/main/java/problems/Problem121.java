package problems;

/**
 * 121. Best Time to Buy and Sell Stock
 * @author Chen Runwen
 * @date 21:45
 */
public class Problem121 {

    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Problem121().maxProfit(prices));
    }

}
