package ds_algo.tree.bst;

import ds_algo.tree.BinaryTreeTraversals;
import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 24/01/21
 * Info: Given a sorted array, create a BST with minimal height (i.e tree should be a balanced binary Search tree).
 **/

public class SortedArrayToBalancedBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Node root = arrayToBST(arr);
        BinaryTreeTraversals.inorderTraversal(root);
    }

    private static Node arrayToBST(int[] arr) {
        return arrayToBST(arr, 0, arr.length - 1);
    }

    private static Node arrayToBST(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }
        int mid = (startIndex + endIndex) / 2;
        Node node = new Node(arr[mid]);
        node.left = arrayToBST(arr, startIndex, mid - 1);
        node.right = arrayToBST(arr, mid + 1, endIndex);
        return node;
    }
}
/*
O/P:
1 2 3 4 5 6 7 8
 */