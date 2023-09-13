package ds_algo.recursion_backtracking;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 13/09/23
 * Info: Sort an array of integer using merge sort
 * <p>
 * Approach: Divide and merge. Use Recursion
 **/

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 7, 4, 1, 6, 5};
        //int[] arr = {5,4,3,2,1,1,0};
        //int[] arr = {1,2,3,4,5,6,6};
        System.out.println("input: " + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("sorted array: " + Arrays.toString(arr));
    }

    //divide
    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        mergeArrays(arr, left, mid, right);
    }

    // merge two arrays with indexes: left to mid , mid+1 to right
    private static void mergeArrays(int[] arr, int left, int mid, int right) {
        //System.out.println("Merging: "+left+","+mid+" "+right);
        int[] arr1 = Arrays.copyOfRange(arr, left, mid + 1); //(mid+1) right index is not inclusive
        int[] arr2 = Arrays.copyOfRange(arr, mid + 1, right + 1);
        //System.out.println(Arrays.toString(arr1)+" "+ Arrays.toString(arr2));
        int start1 = 0;
        int start2 = 0;

        while (start1 < arr1.length && start2 < arr2.length) {
            if (arr1[start1] <= arr2[start2]) {
                arr[left++] = arr1[start1++];
            } else {
                arr[left++] = arr2[start2++];
            }
        }

        while (start1 < arr1.length) {
            arr[left++] = arr1[start1++];
        }
        while (start2 < arr2.length) {
            arr[left++] = arr2[start2++];
        }

    }
}

/*
OP:
input: [9, 7, 4, 1, 6, 5]
sorted array: [1, 4, 5, 6, 7, 9]

 */