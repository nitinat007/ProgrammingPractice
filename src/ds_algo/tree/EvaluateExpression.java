package ds_algo.tree;

/**
 * Author: nitinkumar
 * Created Date: 10/05/20
 * Info: Evaluate expression tree
 **/

public class EvaluateExpression {
    public static void main(String[] args) {
        Node root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("/");
        root.right.right.left = new Node("20");
        root.right.right.right = new Node("2");
        System.out.println(evaluateExpression(root));
    }

    private static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    private static int evaluateExpression(Node root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return Integer.parseInt(root.data);
        }

        // Not possible to have only left or only right child

        return calcuate(root.left, root.right, root.data);

    }

    private static int calcuate(Node left, Node right, String operator) {
        if (operator == "+") {
            return evaluateExpression(left) + evaluateExpression(right);
        } else if (operator == "-") {
            return evaluateExpression(left) - evaluateExpression(right);
        } else if (operator == "*") {
            return evaluateExpression(left) * evaluateExpression(right);
        } else if (operator == "/") {
            return evaluateExpression(left) / evaluateExpression(right);
        }
        return 0;
    }
}
