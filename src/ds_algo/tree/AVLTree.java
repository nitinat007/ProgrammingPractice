package ds_algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: nitinkumar
 * Created Date: 10/05/20
 * Info: Implementation of AVL Tree
 **/

public class AVLTree {
    AVLNode root;

    AVLNode insert(AVLNode node, int data) {
        if (node == null) {
            return new AVLNode(data);
        } else if (node.data < data) {
            node.right = insert(node.right, data);
        } else if (node.data > data) {
            node.left = insert(node.left, data);
        }

        return rebalance(node);
    }

    //re-balance if balance factor >= 2 Or <=-2
    AVLNode rebalance(AVLNode n) {
        updateHeight(n);
        int balanceFactor = getBalanceFactor(n);
        if (balanceFactor > 1) { //right node's height is more
            if (getHeight(n.right.right) > getHeight(n.right.left)) {
                n = leftRotate(n);
            } else { // right-left rotation
                n.right = rightRotate(n.right);
                n = leftRotate(n);
            }
        } else if (balanceFactor < -1) {
            if (getHeight(n.left.left) > getHeight(n.left.right)) {
                n = rightRotate(n);
            } else {
                n.left = leftRotate(n.left);
                n = rightRotate(n);
            }
        }
        return n;
    }

    //delete method

    int getBalanceFactor(AVLNode n) {
        return (n == null) ? 0 : getHeight(n.right) - getHeight(n.left);
    }

    int getHeight(AVLNode nd) {
        return nd == null ? 0 : nd.height;
    }

    void updateHeight(AVLNode n) {
        n.height = 1 + Math.max(getHeight(n.left), getHeight(n.right));
    }

    AVLNode leftRotate(AVLNode X) {
        AVLNode Y = X.right;
        AVLNode Z = Y.left;
        Y.left = X;
        X.right = Z;
        updateHeight(X);
        updateHeight(Y);
        return Y;
    }

    AVLNode rightRotate(AVLNode Y) {
        AVLNode X = Y.left;
        AVLNode Z = X.right;
        X.right = Y;
        Y.left = Z;
        updateHeight(Y);
        updateHeight(X);
        return X;
    }

    void inorderTraversal(AVLNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + "(h:" + root.height + ") ");
            inorderTraversal(root.right);
        }
    }

    public void levelorderTraversal(AVLNode node) {
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            AVLNode polledNode = queue.poll();
            if (polledNode != null) {
                System.out.print(polledNode.data + "(h:" + polledNode.height + ") ");
                queue.add(polledNode.left);
                queue.add(polledNode.right);
            }
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.root = avlTree.insert(avlTree.root, 10);
        avlTree.levelorderTraversal(avlTree.root);
        System.out.println();
        avlTree.root = avlTree.insert(avlTree.root, 20);
        avlTree.levelorderTraversal(avlTree.root);
        System.out.println();
        avlTree.root = avlTree.insert(avlTree.root, 30);
        avlTree.levelorderTraversal(avlTree.root);
        System.out.println();
        avlTree.root = avlTree.insert(avlTree.root, 25);
        avlTree.levelorderTraversal(avlTree.root);
        System.out.println();
        avlTree.root = avlTree.insert(avlTree.root, 55);
        avlTree.levelorderTraversal(avlTree.root);
        System.out.println();
        avlTree.root = avlTree.insert(avlTree.root, 5);
        avlTree.levelorderTraversal(avlTree.root);

        //re-verify  height value of each node once
    }
}

class AVLNode {
    int data;
    AVLNode left, right;
    int height;

    AVLNode(int data) {
        this.data = data;
        this.height = 1;
    }
}
