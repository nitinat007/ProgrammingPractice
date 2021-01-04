package ds_algo.tree.bst;

import ds_algo.tree.BinaryTree;
import ds_algo.tree.BinaryTreeTraversals;
import ds_algo.tree.Node;

import java.util.Arrays;

/**
 * Author: nitinkumar
 * Created Date: 04/01/21
 * Info: Convert a binary tree to binary search tree without changing the structure
 * <p>
 * Store each element in array. sort the array and do inorder traversal. during inorder traversal replace value of each note with array element.
 **/

public class BinaryTreeToBinarySearchTreeWithoutChangingStructure {
    /*
                    22                  22
                   /  \                /  \
                 55    66    to     20     55
                / \     \          / \      \
              20   3     9        3   9     66
     */
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new Node(22);
        binaryTree.root.left = new Node(55);
        binaryTree.root.left.left = new Node(20);
        binaryTree.root.left.right = new Node(3);
        binaryTree.root.right = new Node(66);
        binaryTree.root.right.right = new Node(9);

        System.out.print("Original Tree inorder Traversal: ");
        BinaryTreeTraversals.inorderTraversal(binaryTree.root);

        int[] array = treeToArray(binaryTree);
        Arrays.sort(array);
        //replaceValuesInTreeWithArray(binaryTree.root, array); //works
        replaceValuesInTreeWithArray(binaryTree.root, array, 0);

        System.out.print("\nTransformed Tree inorder Traversal: ");
        BinaryTreeTraversals.inorderTraversal(binaryTree.root);
    }

    /* this also works
        static int curPosition = 0;
        private static void replaceValuesInTreeWithArray(Node nd, int[] arr) {
            if (nd == null) {
                return;
            }
            replaceValuesInTreeWithArray(nd.left, arr);
            nd.data = arr[curPosition++];
            replaceValuesInTreeWithArray(nd.right, arr);
        }
    */
    private static int replaceValuesInTreeWithArray(Node nd, int[] arr, int curPosition) {
        if (nd == null) {
            return curPosition;
        }
        curPosition = replaceValuesInTreeWithArray(nd.left, arr, curPosition);
        nd.data = arr[curPosition++];
        curPosition = replaceValuesInTreeWithArray(nd.right, arr, curPosition);
        return curPosition;
    }

    public static int[] treeToArray(BinaryTree binaryTree) {
        int sizeOfTree = binaryTree.sizeOfTree();
        int[] array = new int[sizeOfTree];
        Node node = binaryTree.root;
        treeToArray(node, array);
        return array;
    }

    static int pos = -1;

    private static int[] treeToArray(Node node, int[] arr) {
        if (node == null) {
            return arr;
        }
        arr[++pos] = node.data;
        arr = treeToArray(node.left, arr);
        arr = treeToArray(node.right, arr);
        return arr;
    }
}
/*
O/P:
Original Tree inorder Traversal: 20 55 3 22 66 9
Transformed Tree inorder Traversal: 3 9 20 22 55 66
 */