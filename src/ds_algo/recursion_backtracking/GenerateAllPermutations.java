package ds_algo.recursion_backtracking;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 17/09/23
 * Info: Print all possible permutations of an integer array
 * <p>
 * Approach: Try to fill every element of array at all possible positions. You can maintain an extra array to track all the items already traversed.
 * Let's rather optimize this by not using extra array for tracking and use swapping rather.
 * <p>
 * Time complexity:
 * Space complexity:
 **/

public class GenerateAllPermutations {

    public static void main(String[] args) {
        //int[] arr = {1,2,3};
        int[] arr = {1, 3, 5, 2};
        System.out.println("Input: " + Arrays.toString(arr));
        System.out.println("Output:");
        printPermutationsOdAnArray(0, arr, new int[arr.length], 0);

    }

    private static void printPermutationsOdAnArray(int curPosition, int[] arr, int[] genPermutation, int curPerm) {
        //base case
        if (curPerm == arr.length) {
            System.out.println(Arrays.toString(genPermutation));
            return;
        }

        for (int i = curPosition; i < arr.length; i++) {
            genPermutation[curPerm] = arr[i];
            swapArr(arr, curPosition, i);
            printPermutationsOdAnArray(curPosition + 1, arr, genPermutation, curPerm + 1);

            swapArr(arr, curPosition, i); // revert swap
            genPermutation[curPerm] = 0; // reset gen Permutation
        }

    }

    private static void swapArr(int[] arr, int pos1, int pos2) {
        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;
    }
}
