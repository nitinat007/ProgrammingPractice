package ds_algo.tree.bst;

import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 07/01/21
 * Info: Given a Level order traversal of a BS tree. Construct the tree
 * <p>
 * Logic: Maintain a range of node value. Find first value in the range and form a node. Recursively do this for left and right node.
 * Alternative approach: This is same question as form a BST from given Array of integers.
 * Time Complexity = O(n2)
 * Space Complexity = O(n)
 **/

public class ConstructBSTFromGivenLevelorderTraversal {
    public static void main(String[] args) {

        /* original tree
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
                    / \
                   6  8
         */

        int[] levelOrderTraversal = {10, 5, 20, 3, 7, 15, 22, 6, 8};
//        Node nd = constructBST(levelOrderTraversal, 0); //incorrect
//        BinaryTreeTraversals.levelorderTraversal(nd); //though the traversal is correct but tree constructed is incorrect
        /* generates below tree
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
                / \
               6  8
         */
        Node nd1 = constructBST1(levelOrderTraversal, Integer.MIN_VALUE, Integer.MAX_VALUE); //correct
        System.out.println(nd1); //correct
        //System.out.println(CheckBinaryTreeIsBinarySearchTree.checkIfBTIsBST(nd1,Integer.MIN_VALUE, Integer.MAX_VALUE)); //returns true
    }

    private static Node constructBST1(int[] lTraversal, int leftRange, int rightRange) {
        int positionOfFirstIntegerInRange = positionOfFirstIntegerInRange(lTraversal, leftRange, rightRange);
        Node node = null;
        if (positionOfFirstIntegerInRange == -1) {
            return node;
        } else {
            node = new Node(lTraversal[positionOfFirstIntegerInRange]);
            node.left = constructBST1(lTraversal, leftRange, lTraversal[positionOfFirstIntegerInRange]);
            node.right = constructBST1(lTraversal, lTraversal[positionOfFirstIntegerInRange], rightRange);
        }
        return node;
    }

    private static int positionOfFirstIntegerInRange(int[] lTraversal, int leftRange, int rightRange) {
        for (int i = 0; i < lTraversal.length; i++) {
            if (lTraversal[i] > leftRange && lTraversal[i] < rightRange) {
                return i;
            }
        }
        return -1;
    }

    private static Node constructBST(int[] lTraversal, int position) {
        if (position >= lTraversal.length) {
            return null;
        }
        Node node = new Node(lTraversal[position]);
        node.left = constructBST(lTraversal, 2 * position + 1);
        node.right = constructBST(lTraversal, 2 * position + 2);
        return node;
    }
}
/*
O/P:
Node{data=10, left=Node{data=5, left=Node{data=3, left=null, right=null}, right=Node{data=7, left=Node{data=6, left=null, right=null}, right=Node{data=8, left=null, right=null}}}, right=Node{data=20, left=Node{data=15, left=null, right=null}, right=Node{data=22, left=null, right=null}}}
 */
