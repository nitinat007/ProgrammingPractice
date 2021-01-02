package ds_algo.dp;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Find the largest possible sum of contiguous subarray within an array.
 * Also known as Kadane's algorithm
 **/


public class LargestSumOfContiguousSubArray {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr1[] = {1, -3, 4, -2, 5, -6, 2};
        printContiguousSubArrayWithMaxSum(arr);
        printContiguousSubArrayWithMaxSum(arr1);
    }

    public static void printContiguousSubArrayWithMaxSum(int[] arr) {
        int left = 0, right = 0, sum = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length; i++) {
            tempSum = tempSum + arr[i];

            if (tempSum > sum) {
                sum = tempSum;
                right = i;
                //  System.out.println("found new max sum of " + sum + " from position " + left + " to " + right);
            } else if (tempSum < 0 && i + 1 < arr.length) {
                left = i + 1;
                //  System.out.println("Reset left to position " + left + " as tempSum is " + tempSum);
                tempSum = 0;

            } else {
                // System.out.println("tempSum is " + tempSum);
            }
        }
        System.out.println("Max sum is " + sum + " from " + left + " to " + right);
    }
}
/*
O/P:
Max sum is 7 from 2 to 6
Max sum is 7 from 2 to 4
 */