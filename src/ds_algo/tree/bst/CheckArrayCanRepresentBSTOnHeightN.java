package ds_algo.tree.bst;

/**
 * Author: nitinkumar
 * Created Date: 12/01/21
 * Info: Given an array of size n, check if this represents a binary search tree of height n.
 * Approach: 1. Either create a BST and while creating check new node is added to the leaf node. 2.Without creating tree. Maintain min and max
 * range while moving to the right of array.
 **/

public class CheckArrayCanRepresentBSTOnHeightN {
    public static void main(String[] args) {

        int[] arr = {12, 8, 5, 7, 6}; //true
        int[] arr1 = {12, 14, 15, 17, 16}; //true
        int[] arr2 = {12, 14, 15, 17}; //true
        int[] arr3 = {12, 14, 15, 13}; //false
        System.out.println(isBST(arr));
        System.out.println(isBST(arr1));
        System.out.println(isBST(arr2));
        System.out.println(isBST(arr3));
    }

    private static boolean isBST(int[] arr) {
        return isBST(arr, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
    }

    private static boolean isBST(int[] arr, int min, int max, int index) {
        if (min > max) {
            return false;
        }
        if (arr[index] < min || arr[index] > max) {
            return false;
        }
        if (index + 1 < arr.length) {
            if (arr[index + 1] <= arr[index]) {
                return isBST(arr, min, arr[index], index + 1);
            } else {
                return isBST(arr, arr[index], max, index + 1);
            }
        }
        return true;
    }
}
/*
O/P:
true
true
true
false
 */