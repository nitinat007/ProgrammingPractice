package ds_algo.tree.bst;

import ds_algo.tree.BinaryTree;
import ds_algo.tree.BinaryTreeTraversals;
import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 18/12/20
 * Info: Convert a BST to a Binary Tree such that sum of all greater keys is added to every key
 **/
        /* Eg
        original BST:
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
        convert to BT
                       52
                     /   \
                    12    42
                   / \    / \
                 3   7   15  22
         */

public class ConvertBSTToBTSuchThatSumOfAllGreaterNodeIsAddedToCurrentNode {
    public static void main(String[] args) {

        BinaryTree bTree = new BinaryTree(); // using Binary Tree as BST is also a BT

        bTree.root = new Node(10);
        bTree.root.left = new Node(5);
        bTree.root.right = new Node(20);
        bTree.root.left.left = new Node(3);
        bTree.root.left.right = new Node(7);
        bTree.root.right.left = new Node(15);
        bTree.root.right.right = new Node(22);

        System.out.println("Original BST: ");
        BinaryTreeTraversals.inorderTraversal(bTree.root);

        new ConvertBSTToBTSuchThatSumOfAllGreaterNodeIsAddedToCurrentNode().transformTreeSuchThatEachNodeIsSumOfNextBiggerNode(bTree.root);
        System.out.println("\nAfter conversion to BT: ");
        BinaryTreeTraversals.inorderTraversal(bTree.root);
    }

    private int transformTreeSuchThatEachNodeIsSumOfNextBiggerNode(Node n) {
        if (n == null) {
            return 0;
        }
        int r = transformTreeSuchThatEachNodeIsSumOfNextBiggerNode(n.right);
        int l = transformTreeSuchThatEachNodeIsSumOfNextBiggerNode(n.left);
        n.data=n.data+r;

        return n.data;
    }
/* Check why this did not work.
    private static int sum;

    private void convertEachNodeToSumOfAllGreaterNodes(Node node) {
        convertEachNodeToSumOfAllGreaterNodes(node, this.sum);
    }

    private void convertEachNodeToSumOfAllGreaterNodes(Node node, int sum) {
        if (node == null) {
            return;
        }
        convertEachNodeToSumOfAllGreaterNodes(node.right, sum);
        sum = sum + node.data;
        node.data = sum;
        convertEachNodeToSumOfAllGreaterNodes(node.left, sum);
    }
  */
}

/*
O/P
Original BST:
3 5 7 10 15 20 22
After conversion to BT:
3 12 7 52 15 42 22
 */