package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 10/01/21
 * Info: Verify if two trees are identical. Two trees are identical if they have same shape and corresponding node values are equal.
 **/

public class CheckIfTwoTreesAreIdentical {
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

        BinaryTree bTree1 = new BinaryTree();
        bTree1.root = new Node(10);
        bTree1.root.left = new Node(5);
        bTree1.root.right = new Node(20);
        bTree1.root.left.left = new Node(3);
        bTree1.root.left.right = new Node(7);
        bTree1.root.left.right.left = new Node(6);
        bTree1.root.left.right.right = new Node(8);
        bTree1.root.right.left = new Node(15);
        bTree1.root.right.right = new Node(22);

        /*
                       10
                     /   \
                    5     20
                   / \    / \
                 3   7   15  22
                    / \
                   6  8
         */
        System.out.println(verifyIfTreesAreIdentical(bTree.root, bTree1.root));
    }

    public static boolean verifyIfTreesAreIdentical(Node nd1, Node nd2) {
        if (nd1 == null && nd2 == null) {
            return true;
        } else if ((nd1 == null && nd2 != null) || (nd1 != null && nd2 == null)) {
            return false;
        } else if (nd1.data != nd2.data) {
            return false;
        }
        return verifyIfTreesAreIdentical(nd1.left, nd2.left) && verifyIfTreesAreIdentical(nd1.right, nd2.right);
    }
}

/*
O/P:
true
 */