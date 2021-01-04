package ds_algo.array;

import java.util.Arrays;

/**
 * Author: nitinkumar
 * Created Date: 05/01/21
 * Info: Given two arrays in increasing order. Merge them into one so that they are arranged in ascending order
 **/

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 6, 8, 10};
        int[] arr3 = mergeTwoArrays(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }

    private static int[] mergeTwoArrays(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0, index3 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                arr3[index3++] = arr1[index1++];
            } else {
                arr3[index3++] = arr2[index2++];
            }
        }
        if (index1 == arr1.length) {
            for (int i = index2; i < arr2.length; i++) {
                arr3[index3++] = arr2[i];
            }
        } else if (index2 == arr2.length) {
            for (int i = index1; i < arr1.length; i++) {
                arr3[index3++] = arr1[i];
            }
        }
        return arr3;
    }
}
/*
O/P:
[1, 2, 3, 5, 6, 7, 8, 9, 10]
 */