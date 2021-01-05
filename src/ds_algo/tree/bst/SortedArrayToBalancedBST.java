package ds_algo.tree.bst;

import ds_algo.tree.BinaryTreeTraversals;
import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: generate a balanced binary search tree from sorted array
 **/

public class SortedArrayToBalancedBST {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        Node root = arrayToBSTConversion(arr, 0, arr.length - 1);
        BinaryTreeTraversals.inorderTraversal(root);
        //System.out.println(root);
    }

    private static Node arrayToBSTConversion(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (startIndex + endIndex) / 2;
        Node nd = new Node(arr[mid]);
        nd.left = arrayToBSTConversion(arr, startIndex, mid - 1);
        nd.right = arrayToBSTConversion(arr, mid + 1, endIndex);
        return nd;
    }
}
/*
O/P:
1 2 3 4 5 6 7
 */