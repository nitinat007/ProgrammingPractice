package ds.tree;

/**
 * Author: nitinkumar
 * Created Date: 07/05/20
 * Info: Node class
 **/

public class Node {
    public int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
/*
    public int compareTo(Node nd) {

        if (this.data == nd.data) {
            return 0;
        } else if (this.data > nd.data) {
            return 1;
        } else {
            return -1;
        }
    }
 */

}
