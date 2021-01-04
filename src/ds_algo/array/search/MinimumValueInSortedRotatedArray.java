package ds_algo.array.search;

/**
 * Author: nitinkumar
 * Created Date: 05/01/21
 * Info: Find Minimum Value In a Sorted and Rotated Array
 **/

public class MinimumValueInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {6, 7, 1, 2, 3, 4, 5};
        int[] arr1 = {6, 1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 1, 2, 3, 4};
        int[] arr3 = {6, 7, 8, 9, 1};
        int[] arr4 = {1, 6, 7, 8, 9};
        int[] arr5 = {2, 1};
        int[] arr6 = {1};
        System.out.println(minVal(arr, 0, arr.length - 1));
        System.out.println(minVal(arr1, 0, arr1.length - 1));
        System.out.println(minVal(arr2, 0, arr2.length - 1));
        System.out.println(minVal(arr3, 0, arr3.length - 1));
        System.out.println(minVal(arr4, 0, arr4.length - 1));
        System.out.println(minVal(arr5, 0, arr5.length - 1));
        System.out.println(minVal(arr6, 0, arr6.length - 1));
    }

    private static int minVal(int[] arr, int start, int end) {
        // System.out.println("Finding from " + start + " to " + end);
        if (start > end) {
            // System.out.println("start is greater than end");
            return arr[0];
        }
        if (start == end) {
            //  System.out.println("start is equal to end");
            return arr[start];
        }
        int mid = (start + end) / 2;
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return arr[mid + 1];
        }
        if (mid > start && arr[mid] < arr[mid - 1]) {
            return arr[mid];
        }
        if (arr[end] > arr[mid]) {
            return minVal(arr, start, mid - 1);
        } else {
            return minVal(arr, mid + 1, end);
        }

    }
}
/*
O/P:
1
1
1
1
1
1
1
 */