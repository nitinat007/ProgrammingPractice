package ds_algo.array;

import java.util.Arrays;

/**
 * Author: nitinkumar
 * Created Date: 26/12/20
 * Info: Find a continuous SubArray with a given Sum. Array is non negative.
 * Logic: Keep pointer for left and right index and start moving towards right. Maintain tempSum (for sum from left to right pointer). Keep adding arr[right] in tempSum if tempSum is less than Sum. If
 * tempSum is equal to sum then print left and right indexes. . Increment left pointer and decrement tempSum by arr[left] if tempSum is more than sum.
 **/

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {2, 1, 8, 15, 3, 10};
        int sum = 11;
        int sum1 = 9;
        int sum2 = 18;
        int sum3 = 28;
        int sum4 = 13;
        int sum5 = 31; //not found
        printSubarrayIndexRangeForGivenSum(arr, sum1);
    }

    private static void printSubarrayIndexRangeForGivenSum(int[] arr, int sum) {
        System.out.println("To find sub-array with sum " + sum+" in array "+ Arrays.toString(arr));
        int lft = 0;
        int rgt = 0;
        int currSum = arr[lft];
        while (rgt != arr.length) {

          //  System.out.println(" left: " + lft + " right: " + rgt + " currSum: " + currSum);
            if (currSum == sum) {
                System.out.println("Found sum from position " + lft + " to " + rgt);
                return;
            } else if (currSum > sum) {
                while (currSum > sum && lft <= rgt) {
                   // System.out.println("increment lft");
                    currSum = currSum - arr[lft++];
                    if (lft > rgt && rgt + 1 < arr.length) {
                        rgt++;
                        currSum = arr[lft];
                    }
                }
                if (currSum == sum) {
                    System.out.println("Found sum from position .. " + lft + " to " + rgt);
                    return;
                }

            } else {
                if (rgt + 1 == arr.length ) {
                    System.out.println("Not found da");
                    return;
                }
                currSum = currSum + arr[++rgt];
              //  System.out.println("increment right ");

            }
        }

        System.out.println("Not found");

    }
}
/*
O/P:
To find sub-array with sum 9 in array [2, 1, 8, 15, 3, 10]
Found sum from position .. 1 to 2
 */