package ds_algo.dp;

import java.util.Arrays;

/**
 * Author: nitinkumar
 * Created Date: 08/01/21
 * Info: Find size of longest subsequence in the array such that the difference between the adjacent elements is 1.
 **/

public class LongestSubseqWithAdjacentElementDiffAs1 {
    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 4, 7, 5, 6}; //expected=5 when sequence is 2,3,4,5,6 (Max among 2,3,4,5,6 & 5,6)
        System.out.println("-> " + sizeOfLongestSubSequence(arr));
        int[] arr1 = {4, 5, 4, 7, 3, 2, 8, 9, 1, 0}; //expected=7 when sequence is 4,5,4,3,2,1,0(Max among {4,5,4,3,2,1,0}, {7,8,9})
        System.out.println("-> " + sizeOfLongestSubSequence(arr1));
    }

    private static int sizeOfLongestSubSequence(int[] arr) {
        int[] arrToStoreMaximumSizeAtAPosition = new int[arr.length];
        Arrays.fill(arrToStoreMaximumSizeAtAPosition, 1); //set each value of array as 1
        arrToStoreMaximumSizeAtAPosition[0] = 1;
        //keep moving right and check if there is any value before the current position (say prevPosition) where absolute difference is 1.
        //If value at prefPosition of arrToStoreMaximumSizeAtAPosition added with 1 is more than the value at current position then replace the current value with arrToStoreMaximumSizeAtAPosition added with 1.
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (Math.abs(arr[j] - arr[i]) == 1) {
                    arrToStoreMaximumSizeAtAPosition[i] = Math.max(arrToStoreMaximumSizeAtAPosition[i], arrToStoreMaximumSizeAtAPosition[j] + 1);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < arrToStoreMaximumSizeAtAPosition.length; i++) {
            // System.out.print(arrToStoreMaximumSizeAtAPosition[i] + " ");
            if (arrToStoreMaximumSizeAtAPosition[i] > result) {
                result = arrToStoreMaximumSizeAtAPosition[i];
            }
        }
        return result;
    }
}
/*
O/P:
-> 5
-> 7
 */
