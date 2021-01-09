package ds_algo.tree.bst;

import ds_algo.tree.Node;

/**
 * Author: nitinkumar
 * Created Date: 09/01/21
 * Info: Given a set of numbers form a binary search tree and search for presence of a number in the tree
 **/

public class BinarySearchTreeOperations {
    public Node root = null;

    public BinarySearchTreeOperations(Node root) {
        this.root = root;
    }

    public static void main(String[] args) {
        BinarySearchTreeOperations bst = new BinarySearchTreeOperations(null);
        bst.insertInBST(11);
        bst.insertInBST(9);
        bst.insertInBST(6);
        bst.insertInBST(10);
        bst.insertInBST(15);
        bst.insertInBST(13);
        bst.insertInBST(18);
       // System.out.println(bst.root);
        System.out.println(bst.searchInBST(11)); //true
        System.out.println(bst.searchInBST(6));  //true
        System.out.println(bst.searchInBST(13)); //true
        System.out.println(bst.searchInBST(12)); //false

    }

    public void insertInBST(int num) {
        root = insertInBST1(root, num);
    }

    //non-recursive way
    private Node insertInBST(Node nd, int num) {
        if (nd == null) {
            nd = new Node(num);
            return nd;
        }
        Node temp = root;
        Node prev = null;
        while (temp != null) {
            prev = temp;
            if (num <= temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        if (num <= prev.data) {
            prev.left = new Node(num);
        } else {
            prev.right = new Node(num);
        }
        return root;
    }

    //recursive way
    private Node insertInBST1(Node nd, int num) {
        if (nd == null) {
            nd = new Node(num);
            return nd;
        }
        if (num <= nd.data) {
            if (nd.left == null) {
                nd.left = new Node(num);
            } else {
                insertInBST1(nd.left, num);
            }
        } else {
            if (nd.right == null) {
                nd.right = new Node(num);
            } else {
                insertInBST1(nd.right, num);
            }
        }
        return root;
    }

    public boolean searchInBST(int num) {
        /* return searchInBST(root, num); recursive way */

        // Non recursive way below
        if (root == null) {
            return false;
        }
        Node temp = root;
        while (temp != null) {
            if (temp.data == num) {
                return true;
            }
            if (num < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public boolean searchInBST(Node nd, int num) {
        if (nd == null) {
            return false;
        }
        if (nd.data == num) {
            return true;
        }
        if (num < nd.data) {
            return searchInBST(nd.left, num);
        } else {
            return searchInBST(nd.right, num);
        }
    }
}
/*
O/P:
true
true
true
false
 */