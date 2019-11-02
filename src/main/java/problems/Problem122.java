package problems;

/**
 * 122. Best Time to Buy and Sell Stock II
 * @author Chen Runwen
 * @date 22:00
 */
public class Problem122 {

    /**
     * 不需要考虑具体什么时候买卖，只需要知道所有价差都能赚到，直接求和就行
     */
    public int maxProfit(int[] prices) {
        int lastPrice = 0x7fffffff;
        int sum = 0;
        for (int price : prices) {
            if (price > lastPrice) {
                sum += price - lastPrice;
            }
            lastPrice = price;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(new Problem122().maxProfit(prices));
    }

}
