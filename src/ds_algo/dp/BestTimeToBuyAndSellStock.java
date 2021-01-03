package ds_algo.dp;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Given an array where each value denoting price of stock on that day. Find when to buy and sell stock to realize maximum profit
 *
 * We can also solve this in bruteforce way where time complexity will be O(n^2) and space complexity is O(1). This solution has this both time and space complexity of O(n)
 **/

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int prices[] = {7, 1, 5, 3, 6, 4};
        printWhenToBuyAndSell(prices);
        int prices1[] = {7, 1, 5, 3, 2, 6};
        printWhenToBuyAndSell(prices1);
    }

    private static void printWhenToBuyAndSell(int[] prices) {
        int[] maxArray = new int[prices.length]; //array to store maximum value of Selling price at ith index.
        int tempMax = Integer.MIN_VALUE;
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] > tempMax) {
                tempMax = prices[i];
            }
            maxArray[i] = tempMax;
        }

        int maxRealizedProfit = 0;
        int buyPrice=prices[0];
        int sellPrice=prices[0];
        for(int i=0; i<prices.length;i++){
            if(maxArray[i]-prices[i]>maxRealizedProfit){
                maxRealizedProfit= maxArray[i]-prices[i];
                buyPrice= prices[i];
                sellPrice=maxArray[i];
            }
        }
        System.out.println("maximum profit is "+maxRealizedProfit+" when bought at "+buyPrice+" and sold at "+sellPrice );
    }

}
/*
O/P:
maximum profit is 5 when bought at 1 and sold at 6
maximum profit is 5 when bought at 1 and sold at 6
 */