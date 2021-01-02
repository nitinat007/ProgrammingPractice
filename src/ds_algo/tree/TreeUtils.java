package ds_algo.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: nitinkumar
 * Created Date: 07/05/20
 * Info: Utilities Of Tree Data Structure
 **/

public class TreeUtils {
    public Node findDeepestNode(Node node) {
        Node deepestNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node nd = queue.poll();
            if (nd != null) {
                deepestNode = nd;
                queue.add(nd.left);
                queue.add(nd.right);
            }
        }
        return deepestNode;
    }

    public Node findReferenceOfANode(Node rootNode, Node nodeToDelete) {
        Node nodeToReturn = null;
        if (rootNode == nodeToDelete) {
            return rootNode;
        } else {
            if (rootNode.left != null && nodeToReturn == null)
                nodeToReturn = findReferenceOfANode(rootNode.left, nodeToDelete);
            if (rootNode.right != null && nodeToReturn == null)
                nodeToReturn = findReferenceOfANode(rootNode.right, nodeToDelete);
        }
        return nodeToReturn;
    }

    public void deleteDeepestNode(Node rootNode) {
        Node deepestNode = null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node nd = queue.poll();
            if (nd != null) {
                deepestNode = nd;
                queue.add(nd.left);
                queue.add(nd.right);
            }
        }
        // deepestNode=null;
    }

    public Node findParentOfDeepestNode(Node rootNode, Node deepestNode) {
        Queue<Node> queue = new LinkedList<>();
        Node parentOfDeepestNode = null;
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            Node nd = queue.poll();
            if (nd != null) {
                if (nd.left == deepestNode || nd.right == deepestNode) {
                    parentOfDeepestNode = nd;
                    return parentOfDeepestNode;
                }
                queue.add(nd.left);
                queue.add(nd.right);
            }
        }
        return parentOfDeepestNode;
    }
}
