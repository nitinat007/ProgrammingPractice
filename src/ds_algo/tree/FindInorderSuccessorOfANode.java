package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 27/01/21
 * Info: Find the next node of a given node in a binary tree. Assume that each node has a link to its parent
 * Approach: If node has right child, return the leftmost child of right child. Else keep finding the parent of the node such that the child is right child of parent and return parent of the parent found.
 **/

public class FindInorderSuccessorOfANode {
    public static void main(String[] args) {
        SpecialNode root = new SpecialNode(10, null);
        root.left = new SpecialNode(5, root);
        root.right = new SpecialNode(15, root);
        root.left.left = new SpecialNode(3, (SpecialNode) root.left);
        root.left.right = new SpecialNode(8, (SpecialNode) root.left);
        root.left.right.right = new SpecialNode(9, (SpecialNode) root.left.right);
        root.right.left = new SpecialNode(13, (SpecialNode) root.right);
        root.right.right = new SpecialNode(17, (SpecialNode) root.right);
        root.right.right.left = new SpecialNode(16, (SpecialNode) root.right.right);

        /*
                        10
                       /  \
                      5    15
                    / \    / \
                   3   8  13  17
                       \      /
                        9    16
         */
        System.out.println("Inorder successor of " + root.right.data + " is " + inOrderSuccessor((SpecialNode) root.right).data); //for 15
        System.out.println("Inorder successor of " + root.right.right.data + " is " + inOrderSuccessor((SpecialNode) root.right.right)); //for 17
        System.out.println("Inorder successor of " + root.right.right.left.data + " is " + inOrderSuccessor((SpecialNode) root.right.right.left).data); //for 16
        System.out.println("Inorder successor of " + root.left.right.right.data + " is " + inOrderSuccessor((SpecialNode) root.left.right.right).data); //for 9

    }

    public static SpecialNode inOrderSuccessor(SpecialNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return (SpecialNode) node.right;
        } else {
            SpecialNode current = node;
            SpecialNode parent = node.parent;
            while (current != null && parent!= null && parent.right == current) {
                current = current.parent;
                parent = current.parent;
            }
            return parent; //as current is already a left child of parent.
        }
    }
}

class SpecialNode extends Node {
    SpecialNode parent;

    public SpecialNode(int nodeData, SpecialNode parent) {
        super(nodeData);
        this.parent = parent;
    }
}
/*
O/P:
Inorder successor of 15 is 17
Inorder successor of 17 is null
Inorder successor of 16 is 17
Inorder successor of 9 is 10
 */