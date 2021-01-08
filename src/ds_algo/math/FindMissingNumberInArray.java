package ds_algo.math;

/**
 * Author: nitinkumar
 * Created Date: 07/01/21
 * Info: Array of size N contains number from 0 to N. Find the missing number in the array
 **/

public class FindMissingNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2, 7, 8, 9, 0};
        System.out.println(missingNumberInArray(arr));
    }

    private static int missingNumberInArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            sum = sum + i;
        }
        // instead can use sum = (arr.length) * (arr.length + 1) / 2;
        int sumOfArr = 0;
        for (int i = 0; i < arr.length; i++) {
            sumOfArr = sumOfArr + arr[i];
        }
        return sum - sumOfArr;
    }
}
/*
O/P:
6
 */