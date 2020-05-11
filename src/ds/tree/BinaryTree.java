package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 05/05/20
 * Info: Binary tree example
 **/

public class BinaryTree {
    Node root;
    TreeUtils utils = new TreeUtils();

    BinaryTree() {
        root = null;
    }

    BinaryTree(int data) {
        root = new Node(data);
    }

    //**
    public void deleteANode(Node rootNode, Node nodeToDelete) {
        Node deepestNode = utils.findDeepestNode(rootNode);
        //System.out.println("deepest Node: " + deepestNode);
        Node referenceOfANodeToDel = utils.findReferenceOfANode(rootNode, nodeToDelete);
        //System.out.println("Node To Del: " + referenceOfANodeToDel);
        /* this did not work
        referenceOfANodeToDel.data = deepestNode.data;
        deepestNode = null;
         */
        Node deepestNodeParent = utils.findParentOfDeepestNode(rootNode, deepestNode);
        //System.out.println("deepestNodeParent: " + deepestNodeParent);
        referenceOfANodeToDel.data = deepestNode.data;
        if (deepestNodeParent.left == deepestNode) {
            deepestNodeParent.left = null;
        } else {
            deepestNodeParent.right = null;
        }
    }

    public static void main(String args[]) {
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
        System.out.println(" Tree is " + bTree.root);
        System.out.print("***\nInorder traversal:");
        BinaryTreeTraversals.inorderTraversal(bTree.root);
        System.out.print("\nInorder traversal Non recursive:");
        BinaryTreeTraversals.inorderNonrecursive(bTree.root);
        System.out.print("\nInorder traversal stackless:");
        BinaryTreeTraversals.stacklessInorderTraversal(bTree.root);
        System.out.print("\nPreorder traversal:");
        BinaryTreeTraversals.preorderTraversal(bTree.root);
        System.out.print("\nPreorder traversal Non recursive:");
        BinaryTreeTraversals.preorderNonrecursive(bTree.root);
        System.out.print("\nPostorder traversal:");
        BinaryTreeTraversals.postorderTraversal(bTree.root);
        System.out.print("\nLevelorder traversal:");
        BinaryTreeTraversals.levelorderTraversal(bTree.root);
        System.out.println("\n****\nDeleting Node " + bTree.root.left.right.data + " from tree with root node " + bTree.root.data);
        System.out.print("Inorder traversal before deletion:");
        BinaryTreeTraversals.inorderTraversal(bTree.root);
        bTree.deleteANode(bTree.root, bTree.root.left.right);
        System.out.print("\nInorder traversal after deletion:");
        BinaryTreeTraversals.inorderTraversal(bTree.root);
    }
}

/*
 Output

 Tree is Node{data=10, left=Node{data=5, left=Node{data=3, left=null, right=null}, right=Node{data=7, left=Node{data=6, left=null, right=null}, right=Node{data=8, left=null, right=null}}}, right=Node{data=20, left=Node{data=15, left=null, right=null}, right=Node{data=22, left=null, right=null}}}
***
Inorder traversal:3 5 6 7 8 10 15 20 22
Inorder traversal Non recursive:3 5 6 7 8 10 15 20 22
Preorder traversal:10 5 3 7 6 8 20 15 22
Preorder traversal Non recursive:10 5 3 7 6 8 20 15 22
Postorder traversal:3 6 8 7 5 15 22 20 10
Levelorder traversal:10 5 20 3 7 15 22 6 8
****
Deleting Node 7 from tree with root node 10
Inorder traversal before deletion:3 5 6 7 8 10 15 20 22
Inorder traversal after deletion:3 5 6 8 10 15 20 22

 */


