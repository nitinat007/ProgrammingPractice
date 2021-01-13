package ds_algo.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * Author: nitinkumar
 * Created Date: 13/01/21
 * Info: Given an array, find the increasing sequence (may not be contiguous) in the array which has the maximum sum.
 **/

public class MaximumSumInIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5, 9, 6}; // o/p sequence would be 1,3,5,9
        System.out.println(maxSumOfIncreasingSubSequence(arr));
    }

    private static int maxSumOfIncreasingSubSequence(int[] arr) {
        int dpArr[] = new int[arr.length];
        dpArr[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] + dpArr[j] > dpArr[i] && arr[i] > arr[j]) {
                    dpArr[i] = arr[i] + dpArr[j];
                }
            }
        }
        return Arrays.stream(dpArr).max().getAsInt();
    }
}
/*
O/P:
18
 */