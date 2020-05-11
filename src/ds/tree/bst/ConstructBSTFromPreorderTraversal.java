package ds.tree.bst;

import ds.tree.BinaryTreeTraversals;
import ds.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 12/05/20
 * Info: Construct a BST from given preorder traversal
 **/

public class ConstructBSTFromPreorderTraversal {

    public static void main(String[] args) {
        int pre[] = {40, 30, 35, 80, 100}; // expected : 30 35 40 80 100
        Node root = constructBST(pre, 0, pre.length);
        System.out.print("Inorder Traversal of BST: ");
        BinaryTreeTraversals.inorderTraversal(root);
        //BinaryTreeTraversals.postorderTraversal(root); //35 30 100 80 40
    }

    private static Node constructBST(int[] pre, int startIndex, int endIndex) {
       // System.out.println("\nconstructing BST from " + startIndex + " to " + endIndex + " index");
        if (startIndex >= endIndex) {
            return null;
        }
        int val = pre[startIndex];
        Node nd = new Node(val);
        int indexOfValueGTVal = findIndexWhoseValueIsGreaterThanGivenValue(pre, val, startIndex + 1, endIndex);
        if (indexOfValueGTVal != -1) {
            nd.left = constructBST(pre, startIndex + 1, indexOfValueGTVal);
            nd.right = constructBST(pre, indexOfValueGTVal, endIndex);
         //   System.out.println(nd.data + " Node's left , right set " + nd);
        }
        return nd;
    }

    private static int findIndexWhoseValueIsGreaterThanGivenValue(int[] pre, int val, int leftBoundary, int rightBoundary) {
        for (int i = leftBoundary; i < rightBoundary; i++) {
            if (pre[i] > val) {
                return i;
            }
        }
        return -1;
    }
}

/*
O/P
Inorder Traversal of BST: 30 35 40 80 100
 */

