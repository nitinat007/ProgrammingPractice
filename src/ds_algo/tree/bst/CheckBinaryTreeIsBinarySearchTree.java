package ds_algo.tree.bst;

import ds_algo.tree.BinaryTree;
import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 03/01/21
 * Info: Given a binary tree, check if it is a binary search tree.
 **/

public class CheckBinaryTreeIsBinarySearchTree {
    public static void main(String[] args) {

        BinaryTree bTree = new BinaryTree();
        bTree.root = new Node(10);
        bTree.root.left = new Node(5);
        bTree.root.right = new Node(20);
        bTree.root.left.left = new Node(3);
        bTree.root.left.right = new Node(7);
        bTree.root.left.right.left = new Node(6);
        bTree.root.left.right.right = new Node(8);
        bTree.root.right.left = new Node(15);
        bTree.root.right.right = new Node(22);

        /*
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
                    / \
                   6  8
         */
        System.out.println(checkIfBTIsBST(bTree));
    }

    private static boolean checkIfBTIsBST(BinaryTree bTree) {

        return checkIfBTIsBST(bTree.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkIfBTIsBST(Node root, int minVal, int maxVal) { //root.data should be in range minVal to maxVal
        if (root == null) {
            return true;
        }
        if (root.data < minVal || root.data > maxVal) {
            return false;
        }
        return checkIfBTIsBST(root.left, minVal, root.data - 1) && checkIfBTIsBST(root.right, root.data + 1, maxVal);
    }

}
/*
O/P:
true
 */