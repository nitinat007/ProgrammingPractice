package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: nitinkumar
 * Created Date: 11/05/20
 * Info: Various traversals in binary tree. Run program from BinaryTree.java
 **/

public class BinaryTreeTraversals {

    public static void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void levelorderTraversal(Node node) {
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

    public static void reverseLevelOrderTraversal(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            if (tmpNode != null) {
                stack.push(tmpNode);
                queue.add(tmpNode.right);
                queue.add(tmpNode.left);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + " ");
        }

    }

    public static void preorderNonrecursive(Node root) {

        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (true) {
            Node nd = stack.pop();
            System.out.print(nd.data + " ");
            if (nd.right != null) {
                stack.push(nd.right);
            }
            if (nd.left != null) {
                stack.push(nd.left);
            }
            if (stack.isEmpty()) {
                break;
            }
        }
        return;
    }

    public static void inorderNonrecursive(Node root) {

        if (root == null) {
            return;
        }
        Node tmp;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        tmp = stack.peek();
        while (!stack.isEmpty()) {
            while (tmp.left != null) {
                tmp = tmp.left;
                stack.push(tmp);
            }
            tmp = stack.pop();
            System.out.print(tmp.data + " ");
            if (tmp.right != null) {
                tmp = tmp.right;
                stack.push(tmp);
            }
        }

        return;
    }

    /**
     * In this traversal, we first create links to Inorder successor and print the data using these links, and finally revert the changes to restore original tree.
     * Based on Morris Traversal
     * Time Complexity: O(n)
     * Level: 4
     *
     * @param root
     */
    public static void stacklessInorderTraversal(Node root) {
        Node current, prev;
        if (root == null) {
            return;
        }
        current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                //setting right child of rightmost child of current's left
                prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right; //finding rightmost child
                }
                if (prev.right == null) {
                    prev.right = current; //set
                    current = current.left;
                } else { // i.e prev.right was set before
                    prev.right = null; //reset
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }


    }

}
