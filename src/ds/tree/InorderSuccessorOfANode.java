package ds.tree;

/**
 * Author: nitinkumar
 * Created Date: 13/05/20
 * Info: Finding inorder successor (next node) of a node
 * Level: 3
 **/

public class InorderSuccessorOfANode {

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
        //Inorder traversal : 3 5 6 7 8 10 15 20 22
        Node successor = findInorderSuccessor(bTree.root, 6);
        if (successor != null)
            System.out.println("ans: " + successor.data);
        else {
            System.out.println("ans: No Successor");
        }
    }

    static Node foundNode = null;

    private static Node findInorderSuccessor(Node root, int nodeValue) {
        Node nodeToReturn = null;
        if (root != null) {
            nodeToReturn = findInorderSuccessor(root.left, nodeValue);
            if (nodeToReturn == null) {
                if (root.data == nodeValue) {
                    foundNode = root;
                } else if (foundNode != null) {
                    return root;
                }
                nodeToReturn = findInorderSuccessor(root.right, nodeValue);
            }
        }
        return nodeToReturn;
    }

}
/*
O/P
ans: 7
 */
