package ds_algo.math;

/**
 * Author: nitinkumar
 * Created Date: 10/01/21
 * Info: Given an array find the size of longest increasing subSequence.
 **/

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 3, 4, 5, 7, 8, 9};
        int[] arr1 = {5, 6, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(sizeOfLongestSubSequence(arr));
        System.out.println(sizeOfLongestSubSequence(arr1));
    }

    private static int sizeOfLongestSubSequence(int[] arr) {
        int size = 0;
        int tempSize = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] + 1 == arr[i]) {
                tempSize++;
                if (i == arr.length - 1 && tempSize > size) {
                    size = tempSize;
                }
            } else {
                if (tempSize > size) {
                    size = tempSize;
                }
                tempSize = 1;
            }
        }
        return size;
    }
}
/*
O/P:
4
8
 */
