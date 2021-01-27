package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 28/01/21
 * Info: Given a binary tree, write a program to find the maximum path sum between any two node in the tree. Path may not pass through the root node. The two nodes may not be the leaf nodes.
 **/

public class MaximumPathSumInBinaryTree {
    private static int maxSum = 0; //variable keeps track of maximum sum b/w any pair of node

    public static void main(String[] args) {
        BinaryTree bTree = new BinaryTree();
        bTree.root = new Node(10);
        bTree.root.left = new Node(5);
        bTree.root.right = new Node(7);
        bTree.root.left.left = new Node(-3);
        bTree.root.left.right = new Node(-2);
        bTree.root.left.right.left = new Node(-4);
        bTree.root.left.right.right = new Node(-8);
        bTree.root.right.left = new Node(8);
        bTree.root.right.right = new Node(-8);

        /*
        Here the path with maximum sum is highlighted by // or \\.
                       10
                     //  \\
                    5     7
                   /\    //\
                 -3 -2   8 -8
                    / \
                  -4  -8
         */
        maximumPathSum(bTree.root);
        System.out.println("For bTree the maximum path sum is " + maxSum);

        //Now validating for leaf to leaf path
        maxSum = 0;
        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = new Node(10);
        bTree1.root.left = new Node(5);
        bTree1.root.right = new Node(7);
        bTree1.root.left.left = new Node(-3);
        bTree1.root.left.right = new Node(-2);
        bTree1.root.left.right.left = new Node(4);
        bTree1.root.left.right.right = new Node(-8);
        bTree1.root.right.left = new Node(8);
        bTree1.root.right.right = new Node(-8);

        /*
        Here the path with maximum sum is highlighted by // or \\.
                       10
                     //  \\
                    5     7
                   /\\    //\
                 -3 -2   8 -8
                   // \
                   4  -8
         */
        maximumPathSum(bTree1.root);
        System.out.println("For bTree1 the maximum path sum is " + maxSum);
    }

    public static int maximumPathSum(Node node) {
        if (node == null) {
            return 0;
        }
        int leftPathLength = maximumPathSum(node.left);
        int rightPathLength = maximumPathSum(node.right);

        //check and update maxSum
        // System.out.println("\ninitial maxSum=" + maxSum + " leftPathLength=" + leftPathLength + " rightPathLength=" + rightPathLength);
        maxSum = Math.max(maxSum, node.data);
        maxSum = Math.max(maxSum, node.data + leftPathLength);
        maxSum = Math.max(maxSum, node.data + rightPathLength);
        maxSum = Math.max(maxSum, node.data + leftPathLength + rightPathLength);
        // System.out.println("At node " + node.data + " maxSum = " + maxSum);
        return Math.max(node.data, Math.max(node.data + leftPathLength, node.data + rightPathLength));
    }
}
/*
O/P:
For bTree the maximum path sum is 30
For bTree1 the maximum path sum is 32
 */
