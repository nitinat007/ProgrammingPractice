package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

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

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void levelorderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node polledNode = queue.poll();
            if (polledNode != null) {
                System.out.print(polledNode.data + " ");
                queue.add(polledNode.left);
                queue.add(polledNode.right);
            }
        }
    }

    //Important
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
        bTree.root.right.left = new Node(15);
        bTree.root.right.right = new Node(22);

        /*
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
         */
        System.out.println(" Tree is " + bTree.root);
        System.out.print("***\nInorder traversal:");
        bTree.inorderTraversal(bTree.root);
        System.out.print("\nPreorder traversal:");
        bTree.preorderTraversal(bTree.root);
        System.out.print("\nPostorder traversal:");
        bTree.postorderTraversal(bTree.root);
        System.out.print("\nLevelorder traversal:");
        bTree.levelorderTraversal(bTree.root);
        System.out.println("\n****\nDeleting Node " + bTree.root.left.right.data + " from tree with root node " + bTree.root.data);
        System.out.print("Inorder traversal before deletion:");
        bTree.inorderTraversal(bTree.root);
        bTree.deleteANode(bTree.root, bTree.root.left.right);
        System.out.print("\nInorder traversal after deletion:");
        bTree.inorderTraversal(bTree.root);
    }
}


