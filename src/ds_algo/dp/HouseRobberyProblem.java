package ds_algo.dp;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 25/09/23
 * Info: Houses are arranged in a circular fashion. Each house has some money as given by array H. Robber has to rob them such that he
 * can not pick adjacent houses as alternate houses have alarm system. Find maximum amount that robber can rob.
 * <p>
 * Approach: Note that robber can not pick 1st and last house together. He not always has to to pick the alternate house.
 * So, Let's break the problem into two parts: 1. he can pick 0 to N-1 house. 2. he can pick 1 to N house.
 * <p>
 * Time Complexity: O(n)
 * Space complexity: O(1)
 **/

public class HouseRobberyProblem {

    public static void main(String[] args) {
        //int[] H = {6,2,1,1,4}; //ans: 7
        //int[] H = {2, 1, 1, 4}; //ans: 5
        //int[] H = {2,1,6,1,4}; //ans: 10
        int[] H = {2, 1, 6, 1, 4, 7}; //ans: 13
        //int[] H = {2,1}; //ans: 2
        //int[] H = {2}; //ans: 0 . Assumption: As only house is adjacent to itself and will have alarm system. Else we can return the only value.
        System.out.println("Input: " + Arrays.toString(H));

        //recursive solution
        System.out.println("Max amount robbed: " + findMaximumRobbedAmount(H));

        //DP solution
        System.out.println("Max amount robbed: " + findMaximumRobbedAmount2(H));
    }

    //using recursion
    private static int findMaximumRobbedAmount(int[] h) {

        //choose first to 2nd last house
        int amt1 = maxAmount(h, 0, h.length - 2);
        //choose second to last house
        int amt2 = maxAmount(h, 1, h.length - 1);
        return Math.max(amt1, amt2);
    }

    private static int maxAmount(int[] H, int start, int end) {
        if (start > end || start < 0 || start >= H.length) {
            return 0;
        }
        //choose start house
        int amountCollected1 = H[start] + maxAmount(H, start + 2, end);
        //not choose start house
        int amountCollected2 = maxAmount(H, start + 1, end);
        return Math.max(amountCollected1, amountCollected2);
    }

    //using DP. Top-down
    private static int findMaximumRobbedAmount2(int[] h) {
        int[] dp = new int[h.length - 1];
        //choose first to 2nd last house
        int amt1 = maxAmount2(h, 0, h.length - 2, dp);

        dp = new int[h.length - 1];
        //choose second to last house
        int amt2 = maxAmount2(h, 1, h.length - 1, dp);
        return Math.max(amt1, amt2);
    }

    private static int maxAmount2(int[] H, int start, int end, int[] dp) {

        //adding for single element H
        if (start > end) {
            return 0;
        }

        // i track position of DP array. j tracks DP from i-2 to 0 position.
        for (int i = 0; i < dp.length; i++) {
            dp[i] = H[start + i];
            for (int j = i - 2; j >= 0; j--) {
                if (H[start + i] + dp[j] > dp[i]) {
                    dp[i] = H[start + i] + dp[j];
                }
            }

        }

        //System.out.println("->" + Arrays.toString(dp));
        return dp[dp.length - 1];

    }

}

/*
Input: [2, 1, 6, 1, 4, 7]
Max amount robbed: 13
Max amount robbed: 13
 */
