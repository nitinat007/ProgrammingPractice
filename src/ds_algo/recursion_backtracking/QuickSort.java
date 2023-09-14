package ds_algo.recursion_backtracking;

import java.util.Arrays;

/**
 * Author: kunitin
 * Created: 14/09/23
 * Info: Write Program to implement quicksort
 * <p>
 * Logic: Choose a pivot (say left most value). Find the appropriate position to put this pivot in that array.
 * Repeat recursively for array to the left and right of pivot
 * [To find position of pivot:
 * keep i & j pointers moving from left to right and from right to left respectively. Find i position whose value is more than value of pivot position,
 * find j whose value is less than value of pivot position. Now swap values at i & j if i lies to the left of j else swap pivot & j]
 * <p>
 * Time complexity: O(n*log n)
 * Space Complexity: O(1) : Hence, better than Merge sort
 **/

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 6, 4, 1, 9};
        //int[] arr = {1,2,3,4,5,6,7};
        //int[] arr = {6,7,6,5,4,3,2,1,1,0,1};
        System.out.println("Input: " + Arrays.toString(arr));
        quickSortArray(arr);
        System.out.println("Output: " + Arrays.toString(arr));
    }

    private static void quickSortArray(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private static void quickSortHelper(int[] arr, int left, int right) {
        //System.out.println("** quick sort from left=" + left + ", right=" + right);
        if (left >= right) {
            return;
        }
        int pivotPosition = left;
        int i = left + 1;
        int j = right;
        while (i < j) {

            //find i to swap
            while (i < arr.length) {
                if (arr[i] > arr[pivotPosition]) {
                    break;
                }
                i++;
            }
            //print i
            //System.out.println("i position to swap=" + i);

            //find j to swap
            while (j > 0) {
                if (arr[j] < arr[pivotPosition]) {
                    break;
                }
                j--;
            }
            //print j
            //System.out.println("j position to swap=" + j);

            //swap
            //if i< j :swap i & j else: swap j & pivot
            if (j > left && i < arr.length) {
                if (i < j) {
                    //System.out.println("1. swap " + arr[i] + " & " + arr[j] + " positions: i=" + i + ", j=" + j);
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                } else {
                    //System.out.println("2. swap " + arr[pivotPosition] + " & " + arr[j] + " as positions: i=" + i + ", j=" + j);
                    int tmp = arr[pivotPosition];
                    arr[pivotPosition] = arr[j];
                    arr[j] = tmp;
                    pivotPosition = j;
                }
            }
//            System.out.println(Arrays.toString(arr));
//            System.out.println();


        }
        quickSortHelper(arr, left, pivotPosition - 1);
        quickSortHelper(arr, pivotPosition + 1, right);
    }

}
