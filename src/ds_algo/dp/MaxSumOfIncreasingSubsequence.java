package ds_algo.dp;

import java.util.Arrays;

/**
 * Author: nitinkumar
 * Created Date: 10/02/21
 * Info: Given an array of n integer. Find the maximum possible sum of increasing sequence from the array.
 * Approach: Maintain an array (say dpArr) which contains maximum sum till that ('i'th ) position. There will be two nested loops. First
 * loop tracks element (at 'i'th position) from left to right. Second loop (say with counter as 'j') checks each element to the left of 'i'.
 * And if the value of original array (say arr) at 'j' th position is less than value at 'i'th position, check if (arr[i]+ dpArr[j]) is more than original value at dpArr[i].
 * If so then replace it with (arr[i]+ dpArr[j]) value.
 **/

public class MaxSumOfIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 99, 4, 5}; //105 (1 + 2 + 3 + 99)
        System.out.println(maxSubSequence(arr));
    }

    private static int maxSubSequence(int[] arr) {

        int dpArr[] = new int[arr.length];
        Arrays.fill(dpArr, 0);

        for (int i = 0; i < arr.length; i++) {
            dpArr[i] = arr[i];
            for (int j = i; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    dpArr[i] = Math.max(dpArr[i], dpArr[j] + arr[i]);
                }
            }
        }
        return Arrays.stream(dpArr).max().getAsInt();
    }
}
/*
O/P:
105
 */