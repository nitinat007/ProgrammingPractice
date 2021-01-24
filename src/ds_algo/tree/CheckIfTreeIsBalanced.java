package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 09/01/21
 * Info: Check if the given Binary Tree is a balanced binary tree. A tree is balanced if the difference of height between left and right subtree is at most 1.
 **/

public class CheckIfTreeIsBalanced {
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
        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = new Node(10);
        bTree1.root.left = new Node(5);
        bTree1.root.right = new Node(20);
        bTree1.root.left.right = new Node(7);
        bTree1.root.left.right.left = new Node(6);
        bTree1.root.left.right.right = new Node(8);
        bTree1.root.right.left = new Node(15);
        bTree1.root.right.right = new Node(22);

        /*
                       10
                     /   \
                    5     20
                     \    / \
                     7   15  22
                    / \
                   6  8
         */
        System.out.println("*** Approach 1 ***");
        System.out.println(isBalanced(bTree.root)); //true
        System.out.println(isBalanced(bTree1.root)); //false

        System.out.println("*** Approach 2 ***");
        System.out.println(isBalanced1(bTree.root)); //true
        System.out.println(isBalanced1(bTree1.root)); //false
    }

    //Approach 1 : Time Complexity is O(N logN)
    private static boolean isBalanced(Node nd) {
        if (nd == null) {
            return true;
        }
        int leftHeight = height(nd.left);
        int rightHeight = height(nd.right);
        // System.out.println("For node " + nd.data + " leftHeight=" + leftHeight + " rightHeight=" + rightHeight);
        return (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(nd.left) && isBalanced(nd
                .right));
    }

    private static int height(Node nd) {
        if (nd == null) {
            return 0;
        }
        return Math.max(height(nd.left), height(nd.right)) + 1;
    }

    //Approach 2 : Time Complexity is O(N). Space complexity is O(heightOfTree)
    //Here while checking height we can actually check whether a tree is balanced or not. Returns -1 if it is not balanced. Any other value means the tree is balanced.

    private static boolean isBalanced1(Node nd) {
        int h = height1(nd);
        if (h == -1) {
            return false;
        }
        return true;
    }

    private static int height1(Node nd) {
        if (nd == null) {
            return 0;
        }
        int leftTreeHeight = height1(nd.left);
        if (leftTreeHeight == -1) {
            return -1;
        }
        int rightTreeHeight = height1(nd.right);
        if (rightTreeHeight == -1) {
            return -1;
        }
        // System.out.println("For node " + nd.data + " leftHeight=" + leftTreeHeight + " rightHeight=" + rightTreeHeight);
        if (Math.abs(leftTreeHeight - rightTreeHeight) > 1) {
            return -1;
        }

        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
/*
O/P:
true
false
 */