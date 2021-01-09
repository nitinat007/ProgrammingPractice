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
        System.out.println(isBalanced(bTree.root)); //true
        /*
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
                    / \
                   6  8
         */

        bTree.root = new Node(10);
        bTree.root.left = new Node(5);
        bTree.root.right = new Node(20);
        bTree.root.left.right = new Node(7);
        bTree.root.left.right.left = new Node(6);
        bTree.root.left.right.right = new Node(8);
        bTree.root.right.left = new Node(15);
        bTree.root.right.right = new Node(22);
        System.out.println(isBalanced(bTree.root)); //false
        /*
                       10
                     /   \
                    5     20
                     \    / \
                     7   15  22
                    / \
                   6  8
         */

    }

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
}
/*
O/P:
true
false
 */