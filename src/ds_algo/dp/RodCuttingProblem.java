package ds_algo.dp;

/**
 * Author: nitinkumar
 * Created Date: 09/01/21
 * Info: Given N, the size of original rod and an array of size N where each value at ith position corresponds to price of rod of length i. Find how should one cut the rod to realize maximum profit.
 * Note: We need to find all combinations in which rod can be cut and return value which gives maximum selling price.
 ***/

public class RodCuttingProblem {
    public static void main(String[] args) {
        int n = 8;
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20}; //So, SP of rod of length 1 is 1, SP of length 2 is 5. To find maximum SP when rod of length 7 is cut and sold.
        System.out.println(maxPriceOnSellingCutRod(n, price));
        System.out.println(maxPriceOnSellingCutRod1(n, price));

    }

    //using recursion
    private static int maxPriceOnSellingCutRod(int n, int[] price) {
        if (n == 0) {
            return 0;
        }
        int maxSP = 0;
        //let's cut the rod of size n into parts . Say i and (n-i-1). Sum price of rod of size i and maxPriceOnSellingCutRod(n-i-1). If maxSP is less than sum of price of rod of size i and (n-i-1), then replace it with the new price (i.e price of rod of size i and (n-i-1)).
        for (int i = 0; i < n; i++) {
            maxSP = Math.max(maxSP, price[i] + maxPriceOnSellingCutRod(n - 1 - i, price));
        }
        return maxSP;
    }

    //Let's use DP now. In recursive approach, sub problems are solved again and again. This can be avoided if we store the result of the sub problem in a lookup for future use.
    private static int maxPriceOnSellingCutRod1(int n, int[] price) {

        int[] dpLookup = new int[n]; // lookup to be filled in bottom-up manner. dpLookup[i] means Max SP for size of  i+1 length. So, for filling this all previous values must be filled.

        for (int i = 0; i < n; i++) {
            int maxSP = price[i];
            for (int j = 0; j < i; j++) {
                maxSP = Math.max(maxSP, price[j] + dpLookup[i - j - 1]);
               // System.out.println("maxSP:" + maxSP);
            }
            dpLookup[i] = maxSP;
            //System.out.println(" dpLookup[" + i + "]:" + dpLookup[i]);
        }
        return dpLookup[n - 1];
    }
}
/*
O/P:
22
22
 */
